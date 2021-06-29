package ru.hedin.modelka.service;

import org.springframework.stereotype.Repository;
import ru.hedin.modelka.domain.ModUser;

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
        ModUser modUser = new ModUser();
        modUser.setUserName("test_"+ System.currentTimeMillis());
        entityManager.persist(modUser);

        List users = entityManager.createQuery("select u from ModUser u").getResultList();
        return users.size();
    }
}
