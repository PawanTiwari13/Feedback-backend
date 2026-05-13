package com.pawan.feedback.system.dto.response;



import java.util.List;

public class UserResponseDto {

    private Long id;

    private String email;

    private List<String> roles;

    private boolean active;

    public UserResponseDto() {
    }

    public UserResponseDto(
            Long id,
            String email,
            List<String> roles,
            boolean active
    ) {

        this.id = id;

        this.email = email;

        this.roles = roles;

        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}