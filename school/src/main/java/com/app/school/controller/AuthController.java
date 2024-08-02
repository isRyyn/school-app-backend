package com.app.school.controller;

import com.app.school.enums.Role;
import com.app.school.model.Student;
import com.app.school.model.Teacher;
import com.app.school.model.User;
import com.app.school.repository.UserRepository;
import com.app.school.service.AuthService;
import com.app.school.service.StudentService;
import com.app.school.service.TeacherService;
import com.app.school.service.impl.SharedService;
import com.app.school.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SharedService sharedService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(authService.getUserById(id));
    }

    @PostMapping("/login/{sessionId}")
    public ResponseEntity<Long> login(@PathVariable Long sessionId, @RequestBody User user) {
        try {
            sharedService.setSelectedSession(sessionId);
            return ResponseEntity.ok(authService.login(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/update-credentials")
    public ResponseEntity<Void> updateCredentials(@RequestBody User user) {
        try {
            authService.updateCredentials(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

        try {
            user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
            User savedUser = userRepository.save(user);

            if(user.getRole() == Role.STUDENT) {
                Student s = studentService.getStudentById(user.getUserId());
                s.setUserId(savedUser.getId());
                studentService.addStudent(s, false);
            } else if (user.getRole() == Role.TEACHER) {
                Teacher t = teacherService.getTeacherById(user.getUserId());
                t.setUserId(savedUser.getId());
                teacherService.addTeacher(t);
            }
             return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            authService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
