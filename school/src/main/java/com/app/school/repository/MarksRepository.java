package com.app.school.repository;

import com.app.school.enums.ExamType;
import com.app.school.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findAllByStandardIdAndExamNameAndSessionId(Long standardId, ExamType examName, Long sessionId);

    List<Marks> findAllBySessionIdAndStudentId(Long sessionId, Long studentId);
}
