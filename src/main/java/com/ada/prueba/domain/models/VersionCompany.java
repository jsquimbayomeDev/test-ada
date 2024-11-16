package com.ada.prueba.domain.models;


import jakarta.persistence.*;

@Entity
@Table(name = "version_company", uniqueConstraints = { @UniqueConstraint(columnNames = {"companyId", "versionId"}) })
public class VersionCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long versionCompanyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "versionId", nullable = false)
    private Version version;

    private String versionCompanyDescription;

    public VersionCompany(){};

    public VersionCompany(Long versionCompanyId, Company company, Version version, String versionCompanyDescription) {
        this.versionCompanyId = versionCompanyId;
        this.company = company;
        this.version = version;
        this.versionCompanyDescription = versionCompanyDescription;
    }

    public Long getVersionCompanyId() {
        return versionCompanyId;
    }

    public void setVersionCompanyId(Long versionCompanyId) {
        this.versionCompanyId = versionCompanyId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getVersionCompanyDescription() {
        return versionCompanyDescription;
    }

    public void setVersionCompanyDescription(String versionCompanyDescription) {
        this.versionCompanyDescription = versionCompanyDescription;
    }
}
