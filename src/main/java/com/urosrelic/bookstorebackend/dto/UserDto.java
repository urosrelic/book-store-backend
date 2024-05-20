package com.urosrelic.bookstorebackend.dto;

import com.urosrelic.bookstorebackend.security.SecurityUser;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDto {
    private String username;
    private Set<String> roles;

    public UserDto() {
    }


    public UserDto(SecurityUser securityUser) {
        this.username = securityUser.getUsername();
        this.roles = securityUser.getAuthorities().stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.toSet());
    }

    public UserDto(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }
}
