package com.pd.server.category;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

public interface EncodingRepo extends GeneralJpaRepo<EncodingEntity, EncodingDTO, Byte> {
}
