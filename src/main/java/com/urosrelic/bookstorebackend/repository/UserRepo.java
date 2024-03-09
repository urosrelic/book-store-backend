package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
