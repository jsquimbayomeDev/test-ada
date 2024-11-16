package com.ada.prueba.domain.repository;

import com.ada.prueba.domain.models.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VersionRepository extends JpaRepository<Version, Long> {
    Optional<Version> findByApplicationAppCodeAndVersion(String appCode, String version);
}
