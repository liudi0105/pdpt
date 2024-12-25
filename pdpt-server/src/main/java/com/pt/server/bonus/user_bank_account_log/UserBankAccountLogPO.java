package com.pt.server.bonus.user_bank_account_log;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户银行账户日志表
 * 用于记录用户银行账户的操作日志
 */
@Getter
@Setter
@Entity
@Table(name = "user_bank_account_log")
public class UserBankAccountLogPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @Column(nullable = false)
    private Long uid; // 用户ID

    @Column(nullable = false, precision = 20, scale = 1)
    private Double bouns; // 魔力变动数额

    @Column(nullable = false)
    private Byte type; // 交易类型（1: 存入, 2: 取出, 3: 利息结算）

    @Column(nullable = false)
    private String createdAt; // 创建时间

    @Column(nullable = false)
    private String updatedAt; // 更新时间
}