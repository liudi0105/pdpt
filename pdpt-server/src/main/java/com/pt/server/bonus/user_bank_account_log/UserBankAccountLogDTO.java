package com.pt.server.bonus.user_bank_account_log;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户银行账户日志数据传输对象
 * 包含用户银行账户操作的详细记录
 */
@Getter
@Setter
public class UserBankAccountLogDTO {
    private Long id; // 主键
    private Long uid; // 用户ID
    private Double bouns; // 魔力变动数额
    private Byte type; // 交易类型（1: 存入, 2: 取出, 3: 利息结算）
    private String createdAt; // 创建时间
    private String updatedAt; // 更新时间
}