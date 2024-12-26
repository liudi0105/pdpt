package com.pt.server.torrents.torrents_custom_fields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 实体类，映射表 torrent_custom_fields，定义种子的自定义字段。
 */
@Getter
@Setter
@Entity
@Table(name = "torrents_custom_fields")
public class TorrentsCustomFieldsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 主键

    @Column(nullable = false, length = 255)
    private String name; // 字段名称

    @Column(nullable = false, length = 255)
    private String label; // 字段标签

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FieldType type; // 字段类型（例如：text, textarea, select）

    @Column(nullable = false)
    private Byte required; // 是否必填

    @Column(nullable = false)
    private Integer isSingleRow; // 是否单行显示

    @Column
    private String options; // 可选项（适用于select, radio, checkbox）

    @Column
    private String help; // 帮助信息

    @Column
    private String display; // 显示设置

    @Column(nullable = false)
    private Integer priority; // 显示优先级

    @Column(nullable = false)
    private LocalDateTime createdAt; // 创建时间

    @Column(nullable = false)
    private LocalDateTime updatedAt; // 更新时间

    /**
     * 字段类型枚举
     */
    public enum FieldType {
        text, textarea, select, radio, checkbox, image
    }
}