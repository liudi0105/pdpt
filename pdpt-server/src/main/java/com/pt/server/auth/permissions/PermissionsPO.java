package com.pt.server.auth.permissions;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 实体类：权限
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "permissions")
public class PermissionsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    @Column(nullable = false, length = 255)
    private String name; // 权限名称

    @Column(length = 255)
    private String description; // 权限描述
}