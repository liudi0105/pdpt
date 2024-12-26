package com.pt.server.torrents.torrents_custom_field_values;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据传输对象，传输种子自定义字段的值。
 */
@Getter
@Setter
public class TorrentsCustomFieldValuesDTO {
    private Integer id; // 主键
    private Integer torrentId; // 种子ID
    private Integer customFieldId; // 自定义字段ID
    private String customFieldValue; // 自定义字段值
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}