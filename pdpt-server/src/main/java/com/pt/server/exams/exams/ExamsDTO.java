package com.pt.server.exams.exams;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

/**
 * 考核数据传输对象
 */
@Getter
@Setter
public class ExamsDTO {
    private Long id; // 主键ID
    private String name; // 考核名称
    private String description; // 考核描述
    private LocalDateTime begin; // 开始时间
    private LocalDateTime end; // 结束时间
    private Integer duration; // 持续时长（分钟）
    private String filters; // 考核条件
    private String indexes; // 考核指标
    private Byte status; // 考核状态
    private Byte isDiscovered; // 是否可见
    private Integer priority; // 优先级
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}
