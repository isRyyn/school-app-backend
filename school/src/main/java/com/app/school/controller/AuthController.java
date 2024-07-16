package com.app.school.controller;

import com.app.school.model.User;
import com.app.school.repository.UserRepository;
import com.app.school.service.AuthService;
import com.app.school.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String identifier, @RequestParam String password) {
        try {
            return authService.login(identifier, password);
        } catch (Exception e) {
            return "Login failed: " + e.getMessage();
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

}
