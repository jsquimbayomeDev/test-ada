package com.ada.prueba.domain.models;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyCode;
    private String companyName;
    private String companyDescription;

    @OneToMany(mappedBy = "company", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VersionCompany> versionCompany;

    public Company(){};

    public Company(String companyCode, String companyName, String companyDescription) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long id) {
        this.companyId = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public List<VersionCompany> getVersionCompany() {
        return versionCompany;
    }

    public void setVersionCompany(List<VersionCompany> versionCompany) {
        this.versionCompany = versionCompany;
    }

}
