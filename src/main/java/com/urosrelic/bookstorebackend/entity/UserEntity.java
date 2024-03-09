package com.urosrelic.bookstorebackend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @Column(length = 60)
    private String password;
    private String role;
    private boolean enabled = false;
}
