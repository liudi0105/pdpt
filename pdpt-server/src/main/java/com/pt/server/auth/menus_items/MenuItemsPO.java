package com.pt.server.auth.menus_items;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 实体类：菜单项
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "menus_items")
public class MenuItemsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    @Column(nullable = false)
    private Long menuId; // 菜单ID

    @Column(nullable = false)
    private Long parentId; // 父级菜单项ID

    @Column(nullable = false)
    private Integer level; // 层级

    @Column(nullable = false)
    private Integer priority; // 优先级

    @Column(nullable = false)
    private Integer index; // 索引

    @Column(nullable = false)
    private Boolean isLeaf; // 是否为叶子节点

    @Column(nullable = false, length = 255)
    private String url; // 菜单项URL

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text; // 菜单项文本

    @Column(nullable = false, length = 255)
    private String target; // 打开方式，例如 _self 或 _blank

    @Column(columnDefinition = "TEXT")
    private String style; // 自定义样式

    @Column(nullable = false)
    private Integer minClass; // 最低访问权限级别

    @Column(columnDefinition = "JSON")
    private String extra; // 扩展信息
}