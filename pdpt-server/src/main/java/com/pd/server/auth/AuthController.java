package com.pd.server.auth;

import com.pd.server.auth.vo.LoginResultVO;
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
    public LoginResultVO login(@RequestBody LoginParam loginParam) {
        return authService.login(loginParam.username, loginParam.password);
    }

    @Api(path = "logout")
    public void logout() {
        authService.logout();
    }

    @Api(path = "validate")
    public LoginResultVO validation() {
        return authService.validate();
    }

    @Getter
    @Setter
    public static class LoginParam {
        private String username;
        private String password;
    }
}
