package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.User;
import com.urosrelic.bookstorebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // GET
    public List<User> getUsers() {
        return userRepo.findAll();
    }

}
