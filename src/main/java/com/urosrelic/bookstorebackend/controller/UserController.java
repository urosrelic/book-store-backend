package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.UserEntity;
import com.urosrelic.bookstorebackend.model.UserModel;
import com.urosrelic.bookstorebackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers() {
        List<UserEntity> users = userService.getUsers();
        if(!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserModel newUser) {
        return new ResponseEntity<>(userService.saveUser(newUser),HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<UserEntity> loginUser(@RequestBody UserModel userModel) {
        UserEntity user = userService.loginUser(userModel);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
