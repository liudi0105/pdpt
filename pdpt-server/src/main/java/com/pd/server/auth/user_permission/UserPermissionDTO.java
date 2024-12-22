package com.pd.server.auth.user_permission;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class UserPermissionDTO {
    private Long id;
    private Integer uid;
    private String permission;
    private String payload;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
