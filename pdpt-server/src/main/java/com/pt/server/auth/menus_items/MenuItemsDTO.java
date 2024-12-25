package com.pt.server.auth.menus_items;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 数据传输对象：菜单项
 */
@Getter
@Setter
@Accessors(chain = true)
public class MenuItemsDTO {

    private Long id; // 主键ID
    private Long menuId; // 菜单ID
    private Long parentId; // 父级菜单项ID
    private Integer level; // 层级
    private Integer priority; // 优先级
    private Integer index; // 索引
    private Boolean isLeaf; // 是否为叶子节点
    private String url; // 菜单项URL
    private String text; // 菜单项文本
    private String target; // 打开方式，例如 _self 或 _blank
    private String style; // 自定义样式
    private Integer minClass; // 最低访问权限级别
    private String extra; // 扩展信息
}