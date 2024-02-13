package me.parkdaiho.board.config;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.service.UserDatailsCustomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebConfiguration {

    private final UserDatailsCustomService userDatailsCustomService;

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/css/**", "/js/**", "/img/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeHttpRequests()
                        .requestMatchers("/post", "/posts/**", "/api/**").authenticated()
                        .anyRequest().permitAll();


        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")

                .defaultSuccessUrl("/")
                .failureUrl("/?err=unexpected-user")

                .usernameParameter("username")
                .passwordParameter("password")

                .successHandler(authenticationCustomSuccessHandler());

        return http.build();
    }

    @Bean
    public AuthenticationCustomSuccessHandler authenticationCustomSuccessHandler() {
        return new AuthenticationCustomSuccessHandler();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDatailsCustomService)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
