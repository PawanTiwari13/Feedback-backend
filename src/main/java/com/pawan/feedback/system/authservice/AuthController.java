package com.pawan.feedback.system.authservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pawan.feedback.system.dto.request.CreateUserRequestDto;
import com.pawan.feedback.system.dto.request.LoginRequestDto;
import com.pawan.feedback.system.dto.response.LoginResponseDto;
import com.pawan.feedback.system.dto.response.UserResponseDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto request
    ) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(
            @RequestBody CreateUserRequestDto request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.createUser(request));
    }
}