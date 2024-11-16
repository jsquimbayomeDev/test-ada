package com.ada.prueba.mappers;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.domain.models.Company;
import com.ada.prueba.domain.models.Version;

import java.util.List;

public interface ICompanyMapper {

    Company mapperCompanyEntryToCompany(CompanyEntryDTO companyEntryDTO,  Version version);

    CompanyExitDTO mapCompanyToCompanyExit(Company company);

    List<CompanyExitDTO> mapCompanyToCompanyExitList(List<Company> companies);
}
