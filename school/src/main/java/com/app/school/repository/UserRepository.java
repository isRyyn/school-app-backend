package com.app.school.repository;

import com.app.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailOrMobile(String email, String mobile);
}
