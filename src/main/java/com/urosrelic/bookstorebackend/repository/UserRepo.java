package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
