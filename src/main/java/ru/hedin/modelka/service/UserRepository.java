package ru.hedin.modelka.service;

import org.springframework.stereotype.Repository;
import ru.hedin.modelka.domain.ModUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public boolean saveUser (ModUser modUser){
        entityManager.persist(modUser);
        return true;
    }
    public boolean contains (ModUser modUser) {
 //       List <User> usersBase = entityManager.createQuery("select u from User u", User).getResultList();
 //       return usersBase.contains(user);
        return true;
    }
 //   public List<User> getUserList (){
 //       return entityManager.createQuery("select u from User u",User).getResultList();
 //   }
    @Transactional
    public ModUser findUserByName (String username){

        List <ModUser> modUserList = entityManager.createQuery("select u from ModUser u",ModUser.class).getResultList();
        for (ModUser us: modUserList) {
            if (username.equalsIgnoreCase (us.getUserName())) {
                return us;}
        }
        return null;
    }
}
