package MySpringApp.service;

import MySpringApp.dao.UserDao;
import MySpringApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDao = userDaoImpl;
    }

    @Transactional
    @Override
    public void addUser(String name, String lastname, int age) {
        userDao.addUser(name, lastname, age);
    }
    @Transactional
    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(int id, String name, String lastname, int age) {
        userDao.updateUser(id, name, lastname, age);
    }
}
