package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.dto.UserDto;
import com.urosrelic.bookstorebackend.dto.UserLoginDto;
import com.urosrelic.bookstorebackend.dto.UserRegisterDto;
import com.urosrelic.bookstorebackend.entity.UserEntity;
import com.urosrelic.bookstorebackend.exception.UsernameAlreadyExistsException;
import com.urosrelic.bookstorebackend.security.SecurityUser;
import com.urosrelic.bookstorebackend.service.AuthService;
import com.urosrelic.bookstorebackend.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/public/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDto userRegisterDto) {
        try {
            UserEntity user = authService.register(userRegisterDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UsernameAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginDto.getUsername());
            if (passwordEncoder.matches(userLoginDto.getPassword(), userDetails.getPassword())) {
                UserDto userDto = new UserDto((SecurityUser) userDetails);
                return new ResponseEntity<>(userDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid password", HttpStatus.UNAUTHORIZED);
            }
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
