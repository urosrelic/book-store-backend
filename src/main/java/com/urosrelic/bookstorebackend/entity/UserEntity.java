package com.urosrelic.bookstorebackend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    @Column(unique=true)
    private String email;
//    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters long")
    @Column(length = 60)
    private String password;
    private String role;
}
