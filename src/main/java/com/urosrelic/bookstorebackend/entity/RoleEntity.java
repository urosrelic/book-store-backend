package com.urosrelic.bookstorebackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.urosrelic.bookstorebackend.entity.enums.RoleName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<UserEntity> users;
}
