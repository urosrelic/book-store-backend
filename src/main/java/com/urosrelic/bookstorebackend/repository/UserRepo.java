package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}
