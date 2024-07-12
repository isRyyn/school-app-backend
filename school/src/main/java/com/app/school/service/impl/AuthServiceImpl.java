package com.app.school.service.impl;

import com.app.school.model.User;
import com.app.school.repository.UserRepository;
import com.app.school.service.AuthService;
import com.app.school.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public String login(String identifier, String password) {
        User user = userRepository.findByEmailOrMobile(identifier, identifier)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (PasswordUtil.checkPassword(password, user.getPassword())) {
            // Optionally generate a token here
            return "Login successful!";
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
