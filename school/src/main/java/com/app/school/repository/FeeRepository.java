package com.app.school.repository;

import com.app.school.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    List<Fee> findAllByStudentIdAndSessionId(Long studentId, Long sessionId);

    List<Fee> findAllBySessionId(Long sessionId);
}
