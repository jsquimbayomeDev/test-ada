package com.ada.prueba.domain.repository;

import com.ada.prueba.domain.models.Company;
import com.ada.prueba.domain.models.Version;
import com.ada.prueba.domain.models.VersionCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VersionCompanyRepository extends JpaRepository<VersionCompany, Long> {
    Optional<VersionCompany> findByCompanyAndVersion(Company company, Version version);
}
