package com.mb.transfer.TransferToBoot.dao;

import com.mb.transfer.TransferToBoot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(String name, String lastName, int age) {
        entityManager.persist(new User(name,lastName,age));
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void updateUser(int id, String name, String lastName, int age) {
        User user = entityManager.find(User.class,id);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
    }
}
