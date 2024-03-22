package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.User;
import com.urosrelic.bookstorebackend.exceptions.UserAlreadyExistsException;
import com.urosrelic.bookstorebackend.exceptions.WrongPasswordException;
import com.urosrelic.bookstorebackend.exceptions.WrongUsernamException;
import com.urosrelic.bookstorebackend.model.UserModel;
import com.urosrelic.bookstorebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(UserModel userModel) throws UserAlreadyExistsException {

        if (userRepo.findByUsername(userModel.getUsername()) != null) {
            throw new UserAlreadyExistsException("Username already exists");
        }

        if (userRepo.findByEmail(userModel.getEmail()) != null) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepo.save(user);

        return user;
    }

    public User loginUser(String username, String password) throws WrongUsernamException, WrongPasswordException {
        // Find the user by username
        User user = userRepo.findByUsername(username);

        if(user == null) {
            throw new WrongUsernamException();
        }

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new WrongPasswordException();
        }
    }
}
