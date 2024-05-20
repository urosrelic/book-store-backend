package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.repository.UserEntityRepository;
import com.urosrelic.bookstorebackend.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userEntityRepository.findByUsername(username);

        if (user.isPresent()) {
            return new SecurityUser(user.get());
        } else {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
    }
}
