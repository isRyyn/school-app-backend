package com.app.school.service;

import com.app.school.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student addStudent(Student student);

    void removeStudent(Long id);
}
