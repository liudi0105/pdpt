package common.module.jpa;

import common.module.util.AppReflections;
import common.module.webmvc.ValueWrapper;

public interface AppEntityManager<T> {
    T entityManager();

    static <T> AppEntityManager<T> newInstance(Object o) {
        return AppReflections.forName("common.module.jpa.AppEntityManagerImpl", new ValueWrapper<>(o));
    }

    void persist(Object convert);
}
