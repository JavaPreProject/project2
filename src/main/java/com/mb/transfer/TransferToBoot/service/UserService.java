package com.mb.transfer.TransferToBoot.service;

import com.mb.transfer.TransferToBoot.models.User;

import java.util.List;

public interface UserService {
    void addUser(String name, String lastName, int age);
    void removeUserById(int id);
    List<User> getAllUsers();
    User getUserById(int id);
    void updateUser(int id, String name, String lastName, int age);
}
