package com.ada.prueba.domain.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;
    private String appCode;
    private String appName;
    private String appDescription;

    @OneToMany(mappedBy = "application",cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Version> versions;

    public Application(){};

    public Application(String appCode, String appName, String appDescription, List<Version> versions) {
        this.appCode = appCode;
        this.appName = appName;
        this.appDescription = appDescription;
        this.versions = versions;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }
}
