package repositories;

import entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository {

    public User findUserByLogin(String login){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        return em.find(User.class, login);
    }

    public List<User> getAllUsers(){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        List<User> users = em.createQuery("Select b From User b").getResultList();
        return users;
    }

    public List<User> getAllActiveUsers(){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        List<User> users = em.createQuery("Select b From User b Where b.active = true").getResultList();
        return users;
    }

    public void createUser (User user){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void updateUser(User user){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void deleteUser (User user){
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        User foundUser = em.find(User.class, user.getLogin());
        em.remove(foundUser);
        em.getTransaction().commit();
    }
}
