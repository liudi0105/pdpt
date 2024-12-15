package com.pd.server.auth.auth_user;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AuthUserDTO {
    private Integer id;
    private Integer userid;
    private String qq;
    private String cpu;
    private String mac;
    private String userkey;
    private Integer authStr;
    private Instant createdAt;
}
