package com.pt.server.auth.user_permission;


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
@Table(name = "user_permissions")
public class UserPermissionPO {
    @Id
    private Long id;
    private Integer uid;
    private String permission;
    private String payload;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
