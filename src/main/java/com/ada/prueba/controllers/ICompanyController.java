package com.ada.prueba.controllers;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICompanyController {

    ResponseEntity<CompanyExitDTO> createCompany(CompanyEntryDTO companyEntryDTO);

    ResponseEntity<List<CompanyExitDTO>>getAllCompany();

    ResponseEntity<CompanyExitDTO> getCompanyByCode(String code);

    ResponseEntity<CompanyExitDTO> updateCompany(CompanyEntryDTO companyEntryDTO);

    ResponseEntity<Void> deleteCompany(String id);


}
