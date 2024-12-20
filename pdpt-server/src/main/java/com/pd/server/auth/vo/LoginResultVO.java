package com.pd.server.auth.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class LoginResultVO {
    private String username;
    private Long userId;
    private String token;
}
