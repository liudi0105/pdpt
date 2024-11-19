package common.module.jpa;


import common.module.webmvc.ValueWrapper;
import jakarta.persistence.EntityManager;

public class AppEntityManagerImpl implements AppEntityManager {

    private final EntityManager entityManager;

    public AppEntityManagerImpl(ValueWrapper<EntityManager> entityManager) {
        this.entityManager = entityManager.getValue();
    }

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public void persist(Object convert) {
        entityManager.persist(convert);
    }
}
