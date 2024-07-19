package com.app.school.controller;


import com.app.school.model.Student;
import com.app.school.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Student> addStudent(
            @RequestParam("student") String studentJson,
            @RequestParam(value = "picture", required = false) MultipartFile picture) throws IOException {

        // Convert JSON string to Student object
        Student student = new ObjectMapper().readValue(studentJson, Student.class);

        // Set the picture as byte array
        if(picture != null) {
            if (picture.getSize() > 10 * 1024 * 1024) {
                return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).build();
            }
            student.setPicture(picture.getBytes());
        }

        return ResponseEntity.ok(studentService.addStudent(student));
    }


    @PutMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Student> updateStudent(
            @RequestParam("student") String studentJson,
            @RequestParam(value = "picture", required = false) MultipartFile picture) throws IOException {

        Student student = new ObjectMapper().readValue(studentJson, Student.class);

        if(picture != null) {
            if (picture.getSize() > 10 * 1024 * 1024) {
                return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).build();
            }
            student.setPicture(picture.getBytes());
        }
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.noContent().build();
    }
}
