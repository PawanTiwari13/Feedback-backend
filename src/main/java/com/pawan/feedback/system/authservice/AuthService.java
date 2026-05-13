package com.pawan.feedback.system.authservice;

import com.pawan.feedback.system.dto.request.CreateUserRequestDto;
import com.pawan.feedback.system.dto.request.LoginRequestDto;
import com.pawan.feedback.system.dto.response.LoginResponseDto;
import com.pawan.feedback.system.dto.response.UserResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto request);

    UserResponseDto createUser(CreateUserRequestDto request);

}