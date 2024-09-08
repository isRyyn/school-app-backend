package com.app.school.service;

import com.app.school.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student getStudentByCode(String code);

    List<Student> getAllStudentdsByStandardId(Long standardId);

    Student addStudent(Student student, boolean addMapping);

    void saveStudentStandards(List<Long> studentIds, List<Long> standardIds, Long sessionId);

    void removeStudent(Long id);
}
