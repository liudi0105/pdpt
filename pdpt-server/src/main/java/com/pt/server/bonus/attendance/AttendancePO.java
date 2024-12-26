package com.pt.server.bonus.attendance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户签到表
 */
@Getter
@Setter
@Entity
@Table(name = "attendance")
public class AttendancePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Integer uid; // 用户ID

    @Column(nullable = false)
    private Integer points; // 积分

    @Column(nullable = false)
    private Integer days; // 连续签到天数

    @Column(nullable = false)
    private Integer totalDays; // 总签到天数

    @Column(nullable = false)
    private LocalDateTime added; // 签到时间（格式：YYYY-MM-DD HH:mm:ss）
}