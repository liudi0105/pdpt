package com.pt.server.bonus.user_seed_bonus;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户的魔力值（seedbonus）数据传输对象。
 */
@Getter
@Setter
public class UserSeedBonusDTO {

    private Long id; // 唯一标识
    private Long uid; // 用户ID
    private BigDecimal seedBonus; // 用户当前的魔力值（种子积分）
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}