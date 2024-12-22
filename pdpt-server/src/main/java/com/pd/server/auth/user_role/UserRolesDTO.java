package com.pd.server.auth.user_role;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class UserRolesDTO {
    private Long id;
    private Integer uid;
    private Integer roleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
