package ru.hedin.modelka.service;

import org.springframework.stereotype.Repository;
import ru.hedin.modelka.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TestRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int test(){
        User user = new User();
        user.setLogin("test_"+ System.currentTimeMillis());
        entityManager.persist(user);

        List users = entityManager.createQuery("select u from User u").getResultList();
        return users.size();
    }
}
