package com.pt.server.auth.roles;

import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.function.UnaryOperator;

@ApiGroup("role")
public class RoleController {

    @Autowired
    private RolesRepo rolesRepo;

    @Api("list-paged")
    public AppPageResult<RolesDTO> listPaged(@RequestBody AppPageParam pageParam) {
        return rolesRepo.pageQuery(pageParam, UnaryOperator.identity());
    }

}
