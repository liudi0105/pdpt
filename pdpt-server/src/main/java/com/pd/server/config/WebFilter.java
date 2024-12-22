package com.pd.server.config;

import common.module.util.AppEncodings;
import common.module.webmvc.AppCookies;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class WebFilter extends OncePerRequestFilter {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private AppCookies appCookies;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String cSecurePass = appCookies.getCookieValue("c_secure_pass").orElse(null);
        String cSecureUid = appCookies.getCookieValue("c_secure_uid").orElse(null);

        String s = AppEncodings.decodeBase64(cSecureUid);

        currentUser
                .setUserId(Long.parseLong(s))
                .setSecurityPassCookie(cSecurePass)
                .setSecurityUidCookie(cSecureUid);
    }
}
