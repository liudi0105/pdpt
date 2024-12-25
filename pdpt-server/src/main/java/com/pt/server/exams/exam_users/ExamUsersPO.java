package com.pt.server.exams.exam_users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 考核用户持久化对象
 */
@Getter
@Setter
@Entity
@Table(name = "exam_users")
public class ExamUsersPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    @Column(nullable = false)
    private Integer uid; // 用户ID

    @Column(name = "exam_id", nullable = false)
    private Integer examId; // 考核ID

    @Column(nullable = false)
    private Integer status; // 考核状态（0未开始，1进行中，2已完成）

    private LocalDateTime begin; // 考核开始时间

    private LocalDateTime end; // 考核结束时间

    @Column(columnDefinition = "TEXT")
    private String progress; // 考核进度

    @Column(name = "is_done", nullable = false)
    private Byte isDone; // 是否完成

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}
