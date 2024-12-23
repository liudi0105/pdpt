package com.pt.server.log.login;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "login_logs")
public class LoginLogEntity {
    @Id
    private Long id;
    private Integer uid;
    private String ip;
    private String country;
    private String city;
    private String client;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
