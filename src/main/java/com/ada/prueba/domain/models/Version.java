package com.ada.prueba.domain.models;


import jakarta.persistence.*;

@Entity
@Table (name = "application")
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long versionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appId", nullable = false)
    private Application application;

    private String version;
    private String versionDescription;

    public Version(){};

    public Version( Application application, String version, String versionDescription) {
        this.application = application;
        this.version = version;
        this.versionDescription = versionDescription;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }
}
