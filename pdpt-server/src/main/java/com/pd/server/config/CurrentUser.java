package com.pd.server.config;

import com.mysql.cj.log.Log;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@Accessors(chain = true)
@Component
@RequestScope
public class CurrentUser {
    private Long userId;
    private String username;
    private String email;
    private String securityPassCookie;
    private String securityUidCookie;
}
