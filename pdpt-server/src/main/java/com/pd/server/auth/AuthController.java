package com.pd.server.auth;

import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@ApiGroup(path = "auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Api(path = "login")
    public void login(@RequestBody LoginParam loginParam) {
        authService.login(loginParam.username, loginParam.password);
    }

    @Getter
    @Setter
    public static class LoginParam {
        private String username;
        private String password;
    }
}
