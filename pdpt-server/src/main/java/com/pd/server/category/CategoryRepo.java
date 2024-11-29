package com.pd.server.category;

import common.module.jpa.GeneralJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends GeneralJpaRepo<CategoryEntity, CategoryDTO, Short> {
}
