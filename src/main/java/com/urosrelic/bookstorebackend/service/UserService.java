package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.UserEntity;
import com.urosrelic.bookstorebackend.model.UserModel;
import com.urosrelic.bookstorebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // GET
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }

    // POST
    public UserEntity saveUser(UserModel userModel) {
        UserEntity user = new UserEntity();
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepo.save(user);

        return user;
    }

    // POST - Login
    public UserEntity loginUser(String username, String password) {
        // Find the user by username
        UserEntity user = userRepo.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }




}
