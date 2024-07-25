package com.app.school.service;

import com.app.school.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    Teacher addTeacher(Teacher teacher);

    void deleteTeacher(Long id);
}
