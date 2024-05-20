package com.urosrelic.bookstorebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginDto {
    private String username;
    private String password;
}
