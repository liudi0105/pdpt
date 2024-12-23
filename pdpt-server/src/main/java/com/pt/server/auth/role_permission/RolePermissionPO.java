package com.pt.server.auth.role_permission;


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
@Table(name = "role_permissions")
public class RolePermissionPO {
    @Id
    private Long id;
    private Integer roleId;
    private String permission;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
