package com.pd.server.auth;

import com.pd.server.auth.user_info.UsersPO;
import com.pd.server.auth.user_info.UsersRepo;
import common.module.util.AppEncodings;
import common.module.webmvc.AppCookies;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private AppCookies appCookies;

    public void login(String username, String password) {
        UsersPO eq = usersRepo.getPoEq(UsersPO::getUsername, username);
        if (DigestUtils.md5Hex(eq.getSecret() + password + eq.getSecret()).equals(eq.getPasshash())) {
            throw new RuntimeException("验证失败，请重试");
        }

        appCookies.setLongCookie("c_secure_uid", AppEncodings.encodeBase64(eq.getId().toString()));
        appCookies.setLongCookie("c_secure_pass", DigestUtils.md5Hex(eq.getPasshash()));
    }
}
