package com.app.school.service;

import com.app.school.enums.ExamType;
import com.app.school.model.Marks;
import com.app.school.model.Standard;
import com.app.school.model.Student;
import com.app.school.model.Subject;
import jakarta.persistence.MapKey;

import java.util.List;

public interface MarksService {

    List<Marks> getAllMarks();

    List<Marks> getAllMarksByStandardIdAndExamName(Long standardId, ExamType examName);
    void saveMarks(List<Marks> marks);
}
