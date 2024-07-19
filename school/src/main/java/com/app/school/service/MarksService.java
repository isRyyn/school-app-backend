package com.app.school.service;

import com.app.school.model.Marks;
import com.app.school.model.Student;
import com.app.school.model.Subject;

import java.util.List;

public interface MarksService {
    List<Student> getStudentsByStandard(Long classId);

    List<Subject> getSubjectsByStandard(Long classId);

    void saveMarks(List<Marks> marks);
}
