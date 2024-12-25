package com.pt.server.bonus.user_bank_account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 实体类表示用户银行账户表。
 */
@Getter
@Setter
@Entity
@Table(name = "user_bank_account")
public class UserBankAccountPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 用户银行账户的唯一标识

    @Column(nullable = false)
    private Long uid; // 用户ID

    @Column(nullable = false, precision = 20, scale = 1)
    private BigDecimal bouns; // 用户账户总余额

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal rate; // 利率

    @Column(nullable = false)
    private BigDecimal interest; // 已结息金额

    @Column(nullable = false)
    private BigDecimal uninterest; // 未结息金额

    @Column(nullable = false)
    private LocalDateTime createdAt; // 创建时间

    @Column(nullable = false)
    private LocalDateTime updatedAt; // 最后更新时间
}