package com.ada.prueba.repository;

import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CompanyRepository  extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long id);
    Optional<Company> findByCompanyCode(String companyCode);
}
