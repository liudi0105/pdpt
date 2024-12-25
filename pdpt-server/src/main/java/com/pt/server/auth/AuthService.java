package com.pt.server.auth;

import com.pt.server.auth.users.UsersPO;
import com.pt.server.auth.users.UsersRepo;
import com.pt.server.auth.vo.LoginResultVO;
import com.pt.server.config.CurrentUser;
import common.module.util.errors.AppWarning;
import common.module.util.AppEncodings;
import common.module.webmvc.AppCookies;
import common.module.webmvc.AppWebRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private AppCookies appCookies;

    @Autowired
    private AppWebRequest appResponses;

    @Autowired
    private CurrentUser currentUser;

    public LoginResultVO validate() {
        String cSecureUid = currentUser.getSecurityUidCookie();
        String cSecurePass = currentUser.getSecurityPassCookie();
        if (StringUtils.isAnyBlank(cSecurePass, cSecureUid)) {
            appResponses.setResponseStatus(HttpStatus.FORBIDDEN);
            throw new AppWarning("请先登录");
        }

        String s = AppEncodings.decodeBase64(cSecureUid);
        UsersPO eq = usersRepo.findPoEq(UsersPO::getId, Long.parseLong(s))
                .orElseThrow(() -> {
                    appResponses.setResponseStatus(HttpStatus.FORBIDDEN);
                    return new AppWarning("对不起，请先注册");
                });

        if (!DigestUtils.md5Hex(eq.getPasshash()).equals(cSecurePass)) {
            appResponses.setResponseStatus(HttpStatus.FORBIDDEN);
            throw new AppWarning("请重新登录");
        }

        return new LoginResultVO().setUsername(eq.getUsername()).setUserId(eq.getId());
    }

    public void logout() {
        appCookies.expireCookie("c_secure_uid");
        appCookies.expireCookie("c_secure_pass");
    }

    public LoginResultVO login(String username, String password) {
        return validateUser(username, password);
    }

    public LoginResultVO validateUser(String username, String password) {
        UsersPO eq = usersRepo.findPoEq(UsersPO::getUsername, username)
                .orElseThrow(() -> {
                    appResponses.setResponseStatus(HttpStatus.FORBIDDEN);
                    return new AppWarning("对不起，请先注册");
                });

        String s1 = new String(eq.getSecret());
        String s = AppEncodings.md5(s1 + password + s1);
        String passhash = eq.getPasshash();
        // TODO: 密码验证逻辑
        if (!s.equals(passhash)) {
            appResponses.setResponseStatus(HttpStatus.FORBIDDEN);
            throw new RuntimeException("验证失败，请重试");
        }

        appCookies.setLongCookie("c_secure_uid", AppEncodings.encodeBase64(eq.getId().toString()));
        appCookies.setLongCookie("c_secure_pass", DigestUtils.md5Hex(eq.getPasshash()));

        return new LoginResultVO().setUsername(eq.getUsername()).setUserId(eq.getId());
    }
}
