package com.pawan.feedback.system.dto.response;

public class InstituteResponseDto {

    private Long id;

    private String instituteCode;

    private String instituteName;

    private String city;

    private boolean active;

    public InstituteResponseDto() {
    }

    public InstituteResponseDto(
            Long id,
            String instituteCode,
            String instituteName,
            String city,
            boolean active
    ) {

        this.id = id;
        this.instituteCode = instituteCode;
        this.instituteName = instituteName;
        this.city = city;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getInstituteCode() {
        return instituteCode;
    }

    public void setInstituteCode(String instituteCode) {
        this.instituteCode = instituteCode;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}