package com.pt.server.auth.users;

import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.function.UnaryOperator;

@ApiGroup("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Api("list-paged")
    public AppPageResult<UsersDTO> listPaged(@RequestBody AppPageParam pageParam) {
        return userService.getUsersRepo().pageQuery(pageParam, UnaryOperator.identity());
    }

}
