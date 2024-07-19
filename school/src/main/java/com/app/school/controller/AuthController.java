package com.app.school.controller;

import com.app.school.model.User;
import com.app.school.repository.UserRepository;
import com.app.school.service.AuthService;
import com.app.school.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String identifier, @RequestParam String password) {
        try {
            return ResponseEntity.ok(authService.login(identifier, password));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    @PutMapping("/update-credentials")
    public ResponseEntity<String> updateCredentials(@RequestBody User user) {
        try {
            return ResponseEntity.ok(authService.updateCredentials(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Credentials could not be updated: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if(userRepository.findByEmailOrMobile(user.getEmail(), user.getMobile()) != null) {
            try {
                user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
                userRepository.save(user);
                return ResponseEntity.ok("User registered successfully!");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed! " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email/Mobile is already taken");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            authService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User could not be deleted: " + e.getMessage());
        }
    }
}
