package com.app.school.service;

import com.app.school.model.User;

public interface AuthService {
    String login(String identifier, String password);

    String updateCredentials(User user);

    void deleteUser(Long id);
}
