package com.app.school.service;

import com.app.school.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubjects();

    Optional<Subject> getSubjectById(Long id);
    Subject addSubject(Subject subject);

    void deleteSubject(Long id);
}
