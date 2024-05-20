package com.urosrelic.bookstorebackend.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "restricted";
    }

    @GetMapping("/logged_in")
    public String getLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(", "));
        } else {
            return "No authenticated user";
        }
    }
}
