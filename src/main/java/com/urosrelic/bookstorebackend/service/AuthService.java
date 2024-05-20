package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.dto.UserRegisterDto;
import com.urosrelic.bookstorebackend.entity.RoleEntity;
import com.urosrelic.bookstorebackend.entity.UserEntity;
import com.urosrelic.bookstorebackend.entity.enums.RoleName;
import com.urosrelic.bookstorebackend.exception.UsernameAlreadyExistsException;
import com.urosrelic.bookstorebackend.repository.RoleRepository;
import com.urosrelic.bookstorebackend.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserEntityRepository userEntityRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity register(UserRegisterDto userRegisterDto) throws UsernameAlreadyExistsException {
        Optional<UserEntity> existingUser = userEntityRepository.findByUsername(userRegisterDto.getUsername());
        if (existingUser.isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists");
        } else {
            RoleEntity roleEntity = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));

            List<RoleEntity> roles = new ArrayList<>();
            roles.add(roleEntity);

            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userRegisterDto.getUsername());
            userEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
            userEntity.setRoles(new HashSet<>(roles));
            return userEntityRepository.save(userEntity);
        }
    }
}
