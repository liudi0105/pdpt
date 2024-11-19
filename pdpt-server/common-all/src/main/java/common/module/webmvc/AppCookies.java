package common.module.webmvc;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
public class AppCookies {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public Optional<String> getCookieValue(String name) {
        return getCookie(name).map(Cookie::getValue);
    }

    public Optional<Cookie> getCookie(String name) {
        List<Cookie> cookies = Arrays.stream(request.getCookies()).toList();
        if (cookies == null || cookies.isEmpty()) {
            return Optional.empty();
        }
        return cookies.stream()
                .filter(v -> Objects.equals(name, v.getName()))
                .findAny();
    }

    public void expireCookie(String name) {
        expireCookie(name, "/");
    }

    public void expireCookie(String name, String path) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath(path);
        cookie.setMaxAge(0);
        getCookie(name).ifPresent(v -> response.addCookie(cookie));
    }
}
