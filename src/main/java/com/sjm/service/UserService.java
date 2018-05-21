package com.sjm.service;

import com.sjm.domain.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getUsers();

    User getUserById(Integer id);

    void updateUser(User user);

    int findUser(String username, String password);
}
