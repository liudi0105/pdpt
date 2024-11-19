package com.pd.server.user;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private Integer userid;
    private String qq;
    private String cpu;
    private String mac;
    private String userkey;
    private Integer authStr;
    private Instant createdAt;
}
