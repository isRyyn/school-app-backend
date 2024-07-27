package com.app.school.service;

import com.app.school.model.User;

import java.util.List;

public interface AuthService {

    List<User> getAllUsers();

    User getUserById(Long id);
    String login(String identifier, String password);

    String updateCredentials(User user);

    void deleteUser(Long id);
}
