package com.pt.server.torrents.torrents_custom_field_values;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 实体类，映射表 torrents_custom_fields_values，定义种子自定义字段的值。
 */
@Getter
@Setter
@Entity
@Table(name = "torrents_custom_field_values")
public class TorrentsCustomFieldValuesPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 主键

    @Column(nullable = false)
    private Integer torrentId; // 种子ID

    @Column(nullable = false)
    private Integer customFieldId; // 自定义字段ID

    @Column
    private String customFieldValue; // 自定义字段值

    @Column(nullable = false)
    private LocalDateTime createdAt; // 创建时间

    @Column(nullable = false)
    private LocalDateTime updatedAt; // 更新时间
}