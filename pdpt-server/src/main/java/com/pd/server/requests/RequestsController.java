package com.pd.server.requests;

import com.pd.server.log.login.LoginLogDTO;
import com.pd.server.user_info.UserDTO;
import com.pd.server.user_info.UserPO;
import com.pd.server.user_info.UserRepo;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApiGroup("requests")
public class RequestsController {

    @Autowired
    private RequestsRepo requestsRepo;

    @Autowired
    private UserRepo userRepo;

    @Api("list-paged")
    public AppPageResult<RequestsDTO> listPaged(@RequestBody AppPageParam pageParam) {
        return requestsRepo.pageQuery(pageParam, v -> v.orderBy(RequestsEntity::getAdded))
                .handle(this::setUser);
    }

    private void setUser(List<RequestsDTO> postsDTOS) {
        Set<Long> list = postsDTOS.stream().map(RequestsDTO::getUserid).map(Long::valueOf).collect(Collectors.toSet());
        Map<Long, UserDTO> collect = userRepo.listIn(UserPO::getId, list).stream().collect(Collectors.toMap(UserDTO::getId, Function.identity()));
        postsDTOS.stream().filter(v -> collect.containsKey(v.getUserid().longValue()))
                .forEach(v -> v.setUsername(collect.get(v.getUserid().longValue()).getUsername()));
    }
}
