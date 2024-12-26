package com.pt.server.exams.exam_process;

import lombok.Getter;
import lombok.Setter;

/**
 * 考核进度数据传输对象
 */
@Getter
@Setter
public class ExamProgressDTO {
    private Long id; // 主键ID
    private Integer examUserId; // 考核用户ID
    private Integer examId; // 考核ID
    private Integer uid; // 用户ID
    private Integer torrentId; // 种子ID
    private Integer index; // 当前进度索引
    private Long initValue; // 初始值
    private Long value; // 当前值
    private String createdAt; // 创建时间
    private String updatedAt; // 更新时间
}
