package ru.hedin.modelka.service;

import org.springframework.stereotype.Repository;
import ru.hedin.modelka.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class TestRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void test(){
        User user = new User();
        user.setLogin("test_"+ System.currentTimeMillis());
        entityManager.persist(user);
    }
}
