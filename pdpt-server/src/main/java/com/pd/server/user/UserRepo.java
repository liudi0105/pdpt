package com.pd.server.user;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends GeneralJpaRepo<UserEntity, UserDTO, Long> {
}
