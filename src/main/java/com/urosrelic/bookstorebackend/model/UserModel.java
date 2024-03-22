package com.urosrelic.bookstorebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String matchingPassword;
}
