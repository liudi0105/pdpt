package com.pt.server.bonus.user_bank_account_log;

import common.module.jpa.GeneralJpaRepo;

/**
 * 用户银行账户日志表的数据库接口
 * 提供对 `user_bank_account_log` 表的数据库操作
 */
public interface UserBankAccountLogRepository extends GeneralJpaRepo<UserBankAccountLogPO, UserBankAccountLogDTO, Long> {
}