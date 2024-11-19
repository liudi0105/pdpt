package com.pd.server.user;

import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.function.UnaryOperator;

@ApiGroup("user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Api("list-paged")
    public AppPageResult<UserDTO> list(@RequestBody AppPageParam param) {
        return userRepo.pageQuery(param, UnaryOperator.identity());
    }
}
