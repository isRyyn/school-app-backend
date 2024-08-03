package com.app.school.controller;


import com.app.school.model.Student;
import com.app.school.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ServletContext servletContext;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/standard/{standardId}")
    public ResponseEntity<List<Student>> getStudentsByStandardId(@PathVariable Long standardId) {
        return ResponseEntity.ok(studentService.getAllStudentdsByStandardId(standardId));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Student> addStudent(
            @RequestParam("student") String studentJson,
            @RequestParam(value ="picture", required = false) MultipartFile picture) throws IOException {

        // Convert JSON string to Student object
        Student student = new ObjectMapper().readValue(studentJson, Student.class);

        if(picture == null && student.getId() != null) {
            String existingPicture = studentService.getStudentById(student.getId()).getPicture();
            student.setPicture(existingPicture);
        }

        // Set the picture as byte array
        if(picture != null) {
            if (picture.getSize() > 5 * 1024 * 1024) {
                return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).build();
            }
            // Save file to server
            Path uploadsDir = Paths.get(uploadDir);
            String filename = picture.getOriginalFilename();
            Path filePath = uploadsDir.resolve(filename);
            Files.copy(picture.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Update student's picture field
            student.setPicture("api/student/uploads/" + filename);
        }
        return ResponseEntity.ok(studentService.addStudent(student, true));
    }

    @GetMapping("/uploads/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getPicture(@PathVariable String filename) {
        Path filePath = Paths.get(uploadDir).resolve(filename);
        Resource resource = new FileSystemResource(filePath.toFile());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

    @PostMapping("/promote")
    public ResponseEntity<Void> promoteStudents(@RequestParam("studentIds") List<Long> studentIds, @RequestParam("standardIds") List<Long> standardIds, @RequestParam("sessionId") Long sessionId) {
        this.studentService.saveStudentStandards(studentIds, standardIds, sessionId);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.noContent().build();
    }
}
