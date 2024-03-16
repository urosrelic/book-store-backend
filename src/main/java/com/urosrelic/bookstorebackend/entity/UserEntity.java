package com.urosrelic.bookstorebackend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique=true)
    private String username;
    @Column(unique=true)
    private String email;
    @Column(length = 60)
    private String password;
    private String role;
}
