package com.pawan.feedback.system.dto.request;


public class CreateInstituteRequestDto {

    private String instituteCode;

    private String instituteName;

    private String city;

    public CreateInstituteRequestDto() {
    }

    public String getInstituteCode() {
        return instituteCode;
    }

    public void setInstituteCode(String instituteCode) {
        this.instituteCode = instituteCode;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}