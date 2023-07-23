package MySpringApp.dao;

import MySpringApp.models.User;

import java.util.List;

public interface UserDao {
    void addUser(String name, String lastName, int age);
    void removeUserById(int id);
    List<User> getAllUsers();
    User getUserById(int id);
    void updateUser(int id, String name, String lastName, int age);
}
