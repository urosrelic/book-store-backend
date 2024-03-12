package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.UserEntity;
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
    public ResponseEntity<UserEntity> addUser(@RequestBody UserModel newUser) {
        return new ResponseEntity<>(authService.saveUser(newUser), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<UserEntity> loginUser( @RequestParam(name = "username") String username,
                                                 @RequestParam(name = "password") String password) {
        UserEntity user = authService.loginUser(username, password);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
