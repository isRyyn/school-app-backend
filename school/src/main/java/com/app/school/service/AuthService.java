package com.app.school.service;

import com.app.school.enums.Role;
import com.app.school.model.User;

import java.util.List;

public interface AuthService {

    List<User> getAllUsers();

    User getUserById(Long id);
    Long login(User user);

    String updateCredentials(User user);

    void deleteUser(Long id);
}
