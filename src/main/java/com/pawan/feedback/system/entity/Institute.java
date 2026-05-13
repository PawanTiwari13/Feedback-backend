package com.pawan.feedback.system.entity;


import jakarta.persistence.*;

@Entity
@Table(
        name = "institutes",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "institute_code"
                )
        }
)
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "institute_code",
            nullable = false,
            unique = true
    )
    private String instituteCode;

    @Column(
            name = "institute_name",
            nullable = false
    )
    private String instituteName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private boolean active = true;

    public Institute() {
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