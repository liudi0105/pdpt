package com.pt.server.torrents.torrents_custom_fields;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据传输对象，传输种子自定义字段信息。
 */
@Getter
@Setter
public class TorrentsCustomFieldsDTO {

    private Integer id; // 主键
    private String name; // 字段名称
    private String label; // 字段标签
    private String type; // 字段类型（例如：text, textarea, select）
    private Byte required; // 是否必填
    private Integer isSingleRow; // 是否单行显示
    private String options; // 可选项
    private String help; // 帮助信息
    private String display; // 显示设置
    private Integer priority; // 显示优先级
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}