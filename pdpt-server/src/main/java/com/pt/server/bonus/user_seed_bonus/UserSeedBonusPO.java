package com.pt.server.bonus.user_seed_bonus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 实体类表示用户的魔力值（seedbonus）表。
 */
@Getter
@Setter
@Entity
@Table(name = "user_bank_account") // 请根据具体的表名调整
public class UserSeedBonusPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 唯一标识

    @Column(nullable = false)
    private Long uid; // 用户ID

    @Column(nullable = false, precision = 20, scale = 1)
    private BigDecimal seedBonus; // 用户当前的魔力值（种子积分）

    @Column(nullable = false)
    private LocalDateTime createdAt; // 创建时间

    @Column(nullable = false)
    private LocalDateTime updatedAt; // 更新时间
}