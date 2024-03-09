package com.urosrelic.bookstorebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters long")
    @Column(length = 60)
    private String password;
    private String role;
    private boolean enabled = false;
}
