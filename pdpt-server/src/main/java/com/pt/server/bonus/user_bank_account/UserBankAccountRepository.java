package com.pt.server.bonus.user_bank_account;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

/**
 * 用户银行账户的数据访问层接口。
 */
@Repository
public interface UserBankAccountRepository extends GeneralJpaRepo<UserBankAccountPO, UserBankAccountDTO, Long> {
}