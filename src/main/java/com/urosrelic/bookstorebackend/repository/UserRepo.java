package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
