package common.module.jpa;

import common.module.errors.AppError;
import common.module.util.AppJsons;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Component
class BaseJpaRepoAdapterImpl implements BaseJpaRepoAdapter {
    @Override
    public String getTableName(Class<?> entityClass) {
        Table annotation = entityClass.getAnnotation(Table.class);
        if (annotation == null) {
            throw new AppError("Please use '@jakarta.persistence.Table' for entity " + entityClass);
        }
        return annotation.name();
    }

}
