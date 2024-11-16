package com.ada.prueba.mappers.impl;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.domain.models.Version;
import com.ada.prueba.domain.models.VersionCompany;
import com.ada.prueba.mappers.ICompanyMapper;
import com.ada.prueba.domain.models.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper implements ICompanyMapper {

    public Company mapperCompanyEntryToCompany(CompanyEntryDTO companyEntryDTO, Version version) {
        if (companyEntryDTO == null) {
            throw new IllegalArgumentException("The companyEntryDTO cannot be null");
        }
        Company company = new Company(
                companyEntryDTO.getCompanyCode(),
                companyEntryDTO.getCompanyName(),
                companyEntryDTO.getCompanyDescription()
        );

        VersionCompany versionCompany = new VersionCompany();
        versionCompany.setCompany(company);
        versionCompany.setVersion(version);
        company.setVersionCompany(List.of(versionCompany));

        return company;
    }

    @Override
    public CompanyExitDTO mapCompanyToCompanyExit(Company company) {
        if (company == null) {
            throw new IllegalArgumentException("The company cannot be null");
        }
        return new CompanyExitDTO(
                company.getCompanyId(),
                company.getCompanyCode(),
                company.getCompanyName(),
                company.getCompanyDescription(),
                company.getVersionCompany().get(0).getVersion().getApplication().getAppName(),
                company.getVersionCompany().get(0).getVersion().getVersion()
        );
    }

    @Override
    public List<CompanyExitDTO> mapCompanyToCompanyExitList(List<Company> companies) {
        return companies.stream().map(this::mapCompanyToCompanyExit).collect(Collectors.toList());
    }
}
