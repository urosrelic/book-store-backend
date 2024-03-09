package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.UserEntity;
import com.urosrelic.bookstorebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // GET
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }

    // POST
    public UserEntity saveUser(UserEntity newUser) {
        return userRepo.save(newUser);
    }




}
