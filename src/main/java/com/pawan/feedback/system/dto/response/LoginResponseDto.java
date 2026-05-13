package com.pawan.feedback.system.dto.response;

import java.util.List;

public class LoginResponseDto {

    private String token;
    private List<String> roles;
    
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public LoginResponseDto(String token, List<String> roles) {
		super();
		this.token = token;
		this.roles = roles;
	}
    
}