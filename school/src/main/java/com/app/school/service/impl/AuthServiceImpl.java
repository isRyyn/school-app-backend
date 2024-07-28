package com.app.school.service.impl;

import com.app.school.enums.Role;
import com.app.school.model.User;
import com.app.school.repository.UserRepository;
import com.app.school.service.AuthService;
import com.app.school.util.PasswordUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Long login(User u)  {
        User user = userRepository.findByUsername(u.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (PasswordUtil.checkPassword(u.getPassword(), user.getPassword()) && user.getRole() == u.getRole()) {
            // Optionally generate a token here
            return user.getUserId();
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
            userRepository.updateCredentials(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.getUserId());
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
