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
    Optional<User> findByEmailOrMobile(String email, String mobile);

    // Custom method to update user credentials
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("UPDATE User u " +
            "SET " +
            "u.email = :newEmail, " +
            "u.mobile = :newMobile, " +
            "u.password = :newPassword, " +
            "u.role = :newRole " +
            "WHERE u.id = :userId")
    void updateCredentials(@Param("userId") Long userId,
                           @Param("newEmail") String newEmail,
                           @Param("newMobile") String newMobile,
                           @Param("newPassword") String newPassword,
                           @Param("newRole") Role newRole
    );
}
