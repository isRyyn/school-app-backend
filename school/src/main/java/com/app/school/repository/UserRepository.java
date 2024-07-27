package com.app.school.repository;

import com.app.school.enums.Role;
import com.app.school.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);

    // Custom method to update user credentials
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("UPDATE User u " +
            "SET " +
            "u.username = :newUsername, " +
            "u.password = :newPassword, " +
            "u.role = :newRole, " +
            "u.userId = :newUserId " +
            "WHERE u.id = :id")
    void updateCredentials(@Param("id") Long id,
                           @Param("newUsername") String newUsername,
                           @Param("newPassword") String newPassword,
                           @Param("newRole") Role newRole,
                           @Param("newUserId") Long userId
    );
}
