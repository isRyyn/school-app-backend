package com.app.school.repository;

import com.app.school.model.SessionStandardMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionStandardMappingRepository extends JpaRepository<SessionStandardMapping, Long> {
    List<SessionStandardMapping> findAllBySessionIdAndStandardId(Long sessionId, Long standardId);
}
