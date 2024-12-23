package com.pt.server.config;

import common.module.util.AppEncodings;
import common.module.webmvc.AppCookies;
import common.module.webmvc.AppResponses;
import common.module.webmvc.AppWebRequest;
import common.module.webmvc.ErrorResp;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class WebFilter extends OncePerRequestFilter {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private AppCookies appCookies;

    @Autowired
    private AppWebRequest appWebRequest;

    @Autowired
    private AppProperties appProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (appProperties.getAcceptedUrls().contains(servletPath)) {
            filterChain.doFilter(request, response);
            return;
        }

        String cSecurePass = appCookies.getCookieValue("c_secure_pass").orElse(null);
        String cSecureUid = appCookies.getCookieValue("c_secure_uid").orElse(null);

        if (StringUtils.isAnyBlank(cSecurePass, cSecureUid)) {
            appWebRequest.setResponseStatus(HttpStatus.FORBIDDEN);
            AppResponses.respJson(response, new ErrorResp("请先登录"));
            return;
        }

        String s = AppEncodings.decodeBase64(cSecureUid);

        currentUser
                .setUserId(Long.parseLong(s))
                .setSecurityPassCookie(cSecurePass)
                .setSecurityUidCookie(cSecureUid);

        filterChain.doFilter(request, response);
    }
}
