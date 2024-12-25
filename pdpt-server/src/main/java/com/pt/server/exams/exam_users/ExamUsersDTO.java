package com.pt.server.exams.exam_users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

/**
 * 考核用户数据传输对象
 */
@Getter
@Setter
public class ExamUsersDTO {
    private Long id; // 主键ID
    private Integer uid; // 用户ID
    private Integer examId; // 考核ID
    private Integer status; // 考核状态（0未开始，1进行中，2已完成）
    private LocalDateTime begin; // 考核开始时间
    private LocalDateTime end; // 考核结束时间
    private String progress; // 考核进度
    private Byte isDone; // 是否完成
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}
