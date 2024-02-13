package me.parkdaiho.board.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.SerializationUtils;

import java.util.Base64;

public class CookieUtils {

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);

        cookie.setPath("/");
        cookie.setMaxAge(maxAge);

        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();

        if(cookies == null) {
            return;
        }

        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(name)) {
                cookie.setPath("/");
                cookie.setValue("");
                cookie.setMaxAge(0);

                response.addCookie(cookie);
            }
        }
    }

    public static Cookie findCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null) {
            return null;
        }

        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(name)) {
                return cookie;
            }
        }

        return null;
    }

    public static String serialize(Object object) {
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(object));
    }

    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(
                SerializationUtils.deserialize(
                        Base64.getUrlDecoder().decode(cookie.getValue())
                )
        );
    }
}
