package com.ada.prueba.mappers.impl;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.mappers.ICompanyMapper;
import com.ada.prueba.models.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper implements ICompanyMapper {

    public Company mapperCompanyEntryToCompany(CompanyEntryDTO companyEntryDTO) {
        if (companyEntryDTO == null) {
            throw new IllegalArgumentException("The companyEntryDTO cannot be null");
        }
        return new Company(
                companyEntryDTO.getCompanyCode(),
                companyEntryDTO.getCompanyName(),
                companyEntryDTO.getCompanyDescription()
        );
    }

    @Override
    public CompanyExitDTO mapCompanyToCompanyExit(Company company) {
        if (company == null) {
            throw new IllegalArgumentException("The company cannot be null");
        }
        return new CompanyExitDTO(
                company.getId(),
                company.getCompanyCode(),
                company.getCompanyName(),
                company.getCompanyDescription()
        );
    }

    @Override
    public List<CompanyExitDTO> mapCompanyToCompanyExitList(List<Company> companies) {
        return companies.stream().map(this::mapCompanyToCompanyExit).collect(Collectors.toList());
    }


}
