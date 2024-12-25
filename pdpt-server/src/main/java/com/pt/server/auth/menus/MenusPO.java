package com.pt.server.auth.menus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menus")
public class MenusPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 菜单唯一标识符

    @Column(nullable = false, length = 255)
    private String name; // 菜单名称

    @Column(name = "created_at", nullable = false, updatable = false)
    private String createdAt; // 菜单创建时间

    @Column(name = "updated_at", nullable = false)
    private String updatedAt; // 菜单更新时间
}