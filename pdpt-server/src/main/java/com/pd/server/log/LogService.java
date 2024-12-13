package com.pd.server.log;

import com.pd.server.forum.post.PostsDTO;
import com.pd.server.log.login.LoginLogDTO;
import com.pd.server.log.login.LoginLogEntity;
import com.pd.server.log.login.LoginLogRepo;
import com.pd.server.log.site.SiteLogDTO;
import com.pd.server.log.site.SiteLogEntity;
import com.pd.server.log.site.SiteLogRepo;
import com.pd.server.user_info.UserDTO;
import com.pd.server.user_info.UserPO;
import com.pd.server.user_info.UserRepo;
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
    private UserRepo userRepo;

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
        Map<Long, UserDTO> collect = userRepo.listIn(UserPO::getId, list).stream().collect(Collectors.toMap(UserDTO::getId, Function.identity()));
        postsDTOS.forEach(v -> v.setUsername(collect.get(v.getUid().longValue()).getUsername()));
    }

}
