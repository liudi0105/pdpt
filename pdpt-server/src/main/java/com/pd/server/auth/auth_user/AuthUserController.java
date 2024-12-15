package com.pd.server.auth.auth_user;

import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.function.UnaryOperator;

@ApiGroup("auth-user")
public class AuthUserController {

    @Autowired
    private AuthUserRepo authUserRepo;

    @Api("list-paged")
    public AppPageResult<AuthUserDTO> list(@RequestBody AppPageParam param) {
        return authUserRepo.pageQuery(param, UnaryOperator.identity());
    }
}
