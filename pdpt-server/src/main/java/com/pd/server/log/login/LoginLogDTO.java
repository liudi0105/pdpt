package com.pd.server.log.login;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoginLogDTO {
    private Long id;
    private Integer uid;
    private String ip;
    private String country;
    private String city;
    private String client;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
