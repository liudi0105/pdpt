package com.pt.server.auth.user_role;


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
@Table(name = "user_roles")
public class UserRolesPO {
    @Id
    private Long id;
    private Integer uid;
    private Integer roleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
