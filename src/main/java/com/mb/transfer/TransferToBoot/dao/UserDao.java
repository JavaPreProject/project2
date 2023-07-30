package com.mb.transfer.TransferToBoot.dao;

import com.mb.transfer.TransferToBoot.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    void updateUser(int id, String name, String lastName, int age);
}