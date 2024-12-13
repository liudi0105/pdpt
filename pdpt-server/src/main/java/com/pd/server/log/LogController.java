package com.pd.server.log;

import com.pd.server.log.login.LoginLogDTO;
import com.pd.server.log.site.SiteLogDTO;
import common.module.dto.AppPageParam;
import common.module.jpa.AppPageResult;
import common.module.webmvc.Api;
import common.module.webmvc.ApiGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@ApiGroup(path = "log")
public class LogController {

    @Autowired
    private LogService logService;

    @Api(path = "list-site-log-paged")
    public AppPageResult<SiteLogDTO> listSiteLogPaged(@RequestBody AppPageParam appPageParam) {
        return logService.listSiteLogPaged(appPageParam);
    }

    @Api(path = "list-login-log-paged")
    public AppPageResult<LoginLogDTO> listLoginLogPaged(@RequestBody AppPageParam appPageParam) {
        return logService.listLoginLogPaged(appPageParam);
    }

}
