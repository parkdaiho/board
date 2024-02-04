package me.parkdaiho.board.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebConfiguration {

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/css/**", "/js/**", "/img/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")

                .defaultSuccessUrl("/")
                .failureUrl("/login?unexpected-user")

                .usernameParameter("username")
                .passwordParameter("password");

        return http.build();
    }
}
