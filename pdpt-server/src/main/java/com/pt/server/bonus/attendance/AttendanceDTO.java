package com.pt.server.bonus.attendance;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 用户签到数据传输对象
 */
@Getter
@Setter
public class AttendanceDTO {
    private Long id; // 主键
    private Integer uid; // 用户ID
    private Integer points; // 积分
    private Integer days; // 连续签到天数
    private Integer totalDays; // 总签到天数
    private LocalDateTime added; // 签到时间（格式：YYYY-MM-DD HH:mm:ss）
}