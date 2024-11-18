package com.ada.prueba.domain.repository;

import com.ada.prueba.domain.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository  extends JpaRepository<Company, Long> {

    @Query("SELECT DISTINCT c FROM Company c")
    List<Company> findAll();

    Optional<Company> findByCompanyCode(String companyCode);
}
