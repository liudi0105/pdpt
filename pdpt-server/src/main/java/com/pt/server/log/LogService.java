package com.pt.server.log;

import com.pt.server.auth.user_info.UsersDTO;
import com.pt.server.auth.user_info.UsersPO;
import com.pt.server.auth.user_info.UsersRepo;
import com.pt.server.log.login.LoginLogDTO;
import com.pt.server.log.login.LoginLogEntity;
import com.pt.server.log.login.LoginLogRepo;
import com.pt.server.log.site.SiteLogDTO;
import com.pt.server.log.site.SiteLogEntity;
import com.pt.server.log.site.SiteLogRepo;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class LogService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private SiteLogRepo siteLogRepo;

    @Autowired
    private LoginLogRepo loginLogRepo;

    public AppPageResult<SiteLogDTO> listSiteLogPaged(AppPageParam appPageParam) {
        return siteLogRepo.pageQuery(appPageParam, v -> v.orderBy(SiteLogEntity::getAdded));
    }

    public AppPageResult<LoginLogDTO> listLoginLogPaged(AppPageParam appPageParam) {
        return loginLogRepo.pageQuery(appPageParam, v -> v.orderBy(LoginLogEntity::getCreatedAt))
                .handle(this::setUser);
    }

    private void setUser(List<LoginLogDTO> postsDTOS) {
        List<Long> list = postsDTOS.stream().map(LoginLogDTO::getUid).map(Long::valueOf).toList();
        Map<Long, UsersDTO> collect = usersRepo.listIn(UsersPO::getId, list).stream().collect(Collectors.toMap(UsersDTO::getId, Function.identity()));
        postsDTOS.forEach(v -> v.setUsername(collect.get(v.getUid().longValue()).getUsername()));
    }

}
