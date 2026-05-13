package com.pawan.feedback.system.authservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.pawan.feedback.system.entity.User;
import com.pawan.feedback.system.repository.UserRepository;

import java.util.List;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String email
    ) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)

                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found"
                        )
                );

        String role = user.getRoles()
                .stream()
                .findFirst()
                .get()
                .getRole()
                .getName();

        return new org.springframework.security.core.userdetails.User(

                user.getEmail(),

                user.getPassword(),

                List.of(
                        new SimpleGrantedAuthority(
                                "ROLE_" + role
                        )
                )
        );
    }
}