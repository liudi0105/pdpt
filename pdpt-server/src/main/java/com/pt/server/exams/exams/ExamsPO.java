package com.pt.server.exams.exams;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

/**
 * 考核持久化对象
 */
@Getter
@Setter
@Entity
@Table(name = "exams")
public class ExamsPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    @Column(nullable = false, length = 255)
    private String name; // 考核名称

    @Column(columnDefinition = "TEXT")
    private String description; // 考核描述

    private LocalDateTime begin; // 开始时间

    private LocalDateTime end; // 结束时间

    @Column(nullable = false)
    private Integer duration; // 持续时长（分钟）

    @Column(columnDefinition = "TEXT")
    private String filters; // 考核条件

    @Column(columnDefinition = "TEXT", nullable = false)
    private String indexes; // 考核指标

    @Column(nullable = false)
    private Byte status; // 考核状态

    @Column(name = "is_discovered", nullable = false)
    private Byte isDiscovered; // 是否可见

    @Column(nullable = false)
    private Integer priority; // 优先级

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}
