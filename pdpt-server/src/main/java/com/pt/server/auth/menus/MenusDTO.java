package com.pt.server.auth.menus;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class MenusDTO {
    private Long id; // 菜单唯一标识符
    private String name; // 菜单名称
    private String createdAt; // 菜单创建时间
    private String updatedAt; // 菜单更新时间
}