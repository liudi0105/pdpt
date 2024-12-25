package com.pt.server.bonus.interest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 利息记录表
 * 记录用户银行账户的利息信息
 */
@Getter
@Setter
@Entity
@Table(name = "user_bank_account")
public class InterestPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Long uid; // 用户ID

    @Column(nullable = false, precision = 20, scale = 1)
    private Double interest; // 已结利息

    @Column(nullable = false, precision = 20, scale = 1)
    private Double uninterest; // 未结利息

    @Column(nullable = false)
    private String createdAt; // 创建时间

    @Column(nullable = false)
    private String updatedAt; // 更新时间
}