package com.pt.server.bonus.interest;

import common.module.jpa.GeneralJpaRepo;

/**
 * 利息记录表的数据库接口
 * 提供对 `user_bank_account` 表中利息相关字段的数据库操作
 */
public interface InterestRepository extends GeneralJpaRepo<InterestPO, InterestDTO, Long> {
}