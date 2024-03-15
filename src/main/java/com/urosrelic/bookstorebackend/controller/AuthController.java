package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.UserEntity;
import com.urosrelic.bookstorebackend.exceptions.UserAlreadyExistsException;
import com.urosrelic.bookstorebackend.exceptions.WrongPasswordException;
import com.urosrelic.bookstorebackend.exceptions.WrongUsernamException;
import com.urosrelic.bookstorebackend.model.UserModel;
import com.urosrelic.bookstorebackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserModel newUser) {
        try {
            return new ResponseEntity<>(authService.saveUser(newUser), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginUser( @RequestParam(name = "username") String username,
                                                 @RequestParam(name = "password") String password) {
        try {
            UserEntity user = authService.loginUser(username, password);
            return ResponseEntity.ok(user);
        } catch (WrongUsernamException | WrongPasswordException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
