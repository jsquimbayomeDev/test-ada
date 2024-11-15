package com.ada.prueba.domain.repository;

import com.ada.prueba.domain.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository  extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long id);
    Optional<Company> findByCompanyCode(String companyCode);
}
