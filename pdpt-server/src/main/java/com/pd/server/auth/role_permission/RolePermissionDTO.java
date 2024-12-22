package com.pd.server.auth.role_permission;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class RolePermissionDTO {
    private Long id;
    private Integer roleId;
    private String permission;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
