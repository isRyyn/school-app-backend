package com.app.school.service;

import com.app.school.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();

    Subject addSubject(Subject subject);

    void deleteSubject(Long id);
}
