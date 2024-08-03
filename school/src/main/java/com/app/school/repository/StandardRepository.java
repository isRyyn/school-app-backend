package com.app.school.repository;

import com.app.school.model.Standard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StandardRepository extends JpaRepository<Standard, Long> {
    Optional<Standard> findByName(String name);
}
