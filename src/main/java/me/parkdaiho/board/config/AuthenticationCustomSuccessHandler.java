package me.parkdaiho.board.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.util.CookieUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationCustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final String REDIRECT_PATH = "/posts";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if(request.getParameter("remember_id") != null) {
            User user = (User) authentication.getPrincipal();

            CookieUtils.addCookie(response, "remember_id", CookieUtils.serialize(user.getUsername()), 36000);
        }else {
            CookieUtils.deleteCookie(request, response, "remember_id");
        }

        getRedirectStrategy().sendRedirect(request, response, REDIRECT_PATH);
    }
}
