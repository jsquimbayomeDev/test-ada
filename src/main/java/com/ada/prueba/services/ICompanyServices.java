package com.ada.prueba.services;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;

import java.util.List;

public interface ICompanyServices {

    CompanyExitDTO createCompany(CompanyEntryDTO companyEntryDTO);

    List<CompanyExitDTO>getAllCompany();

    CompanyExitDTO getCompanyByCode(String code);

    CompanyExitDTO updateCompany(CompanyEntryDTO companyEntryDTO);

    void deleteCompany(Long id);


}
