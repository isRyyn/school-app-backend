package com.app.school.repository;

import com.app.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStandardId(Long id);

    Optional<Student> findByUDiasCode(String uDiasCode);
}
