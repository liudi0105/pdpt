package com.pd.server.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "user_auth")
public class UserEntity {
    @Id
    private Integer id;
    private Integer userid;
    private String qq;
    private String cpu;
    private String mac;
    private String userkey;
    private Integer authStr;
    private Instant createdAt;
}
