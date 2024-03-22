package com.urosrelic.bookstorebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class User {
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
