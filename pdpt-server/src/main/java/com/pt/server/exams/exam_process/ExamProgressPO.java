package com.pt.server.exams.exam_process;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 考核进度持久化对象
 */
@Getter
@Setter
@Entity
@Table(name = "exam_progress")
public class ExamProgressPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    @Column(name = "exam_user_id", nullable = false)
    private Integer examUserId; // 考核用户ID

    @Column(name = "exam_id", nullable = false)
    private Integer examId; // 考核ID

    @Column(nullable = false)
    private Integer uid; // 用户ID

    @Column(name = "torrent_id", nullable = false)
    private Integer torrentId; // 种子ID

    @Column(nullable = false)
    private Integer index; // 当前进度索引

    @Column(name = "init_value", nullable = false)
    private Long initValue; // 初始值

    @Column(nullable = false)
    private Long value; // 当前值

    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}
