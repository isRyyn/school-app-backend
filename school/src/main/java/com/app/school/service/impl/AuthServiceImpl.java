package com.app.school.service.impl;

import com.app.school.model.User;
import com.app.school.repository.UserRepository;
import com.app.school.service.AuthService;
import com.app.school.util.PasswordUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(String identifier, String password)  {
        User user = userRepository.findByEmailOrMobile(identifier, identifier)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (PasswordUtil.checkPassword(password, user.getPassword())) {
            // Optionally generate a token here
            return "Login successful!";
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @Override
    @Transactional
    public String updateCredentials(User user) {
        userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        try {
            user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
            userRepository.updateCredentials(user.getId(), user.getEmail(), user.getMobile(), user.getPassword(), user.getRole());
            return "Credentials updated";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
    }
}
