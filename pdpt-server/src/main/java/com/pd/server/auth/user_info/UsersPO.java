package com.pd.server.auth.user_info;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UsersPO {
    @Id
    private Long id;
    private String username;
    private String passhash;
    private byte[] secret;
    private String email;
    private LocalDateTime added;
}
