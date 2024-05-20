package com.urosrelic.bookstorebackend.component;

import com.urosrelic.bookstorebackend.entity.RoleEntity;
import com.urosrelic.bookstorebackend.entity.enums.RoleName;
import com.urosrelic.bookstorebackend.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class RoleInitializer {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initRoles() {
        List<RoleName> roleNames = Arrays.asList(RoleName.values());

        for (RoleName roleName : roleNames) {
            Optional<RoleEntity> roleEntityOptional = roleRepository.findByName(roleName);
            if (roleEntityOptional.isEmpty()) {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setName(roleName);
                roleRepository.save(roleEntity);
            }
        }
    }
}