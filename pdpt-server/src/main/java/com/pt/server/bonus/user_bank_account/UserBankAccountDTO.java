package com.pt.server.bonus.user_bank_account;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户银行账户的数据传输对象。
 */
@Getter
@Setter
public class UserBankAccountDTO {

    private Long id; // 用户银行账户的唯一标识
    private Long uid; // 用户ID
    private BigDecimal bouns; // 用户账户总余额
    private BigDecimal rate; // 利率
    private BigDecimal interest; // 已结息金额
    private BigDecimal uninterest; // 未结息金额
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 最后更新时间
}