package com.pawan.feedback.system.dto.request;

public class ChangePasswordRequestDto {

    private String oldPassword;

    private String newPassword;

    public ChangePasswordRequestDto() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}