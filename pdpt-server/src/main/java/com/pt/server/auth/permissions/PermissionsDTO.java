package com.pt.server.auth.permissions;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据传输对象：权限
 */
@Getter
@Setter
@Accessors(chain = true)
public class PermissionsDTO {

    private Long id; // 主键ID
    private String name; // 权限名称
    private String description; // 权限描述
}