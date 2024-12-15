package com.pd.server.auth.auth_user;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepo extends GeneralJpaRepo<AuthUserEntity, AuthUserDTO, Long> {
}
