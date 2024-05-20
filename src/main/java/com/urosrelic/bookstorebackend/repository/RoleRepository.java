package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.RoleEntity;
import com.urosrelic.bookstorebackend.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(RoleName name);
}
