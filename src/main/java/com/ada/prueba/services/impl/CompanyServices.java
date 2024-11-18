package com.ada.prueba.services.impl;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.commons.exceptions.AlreadyExistsException;
import com.ada.prueba.commons.exceptions.NotFoundException;
import com.ada.prueba.mappers.ICompanyMapper;
import com.ada.prueba.domain.models.Company;
import com.ada.prueba.domain.models.Version;
import com.ada.prueba.domain.models.VersionCompany;
import com.ada.prueba.domain.repository.CompanyRepository;
import com.ada.prueba.domain.repository.VersionRepository;
import com.ada.prueba.domain.repository.VersionCompanyRepository;
import com.ada.prueba.services.ICompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompanyServices implements ICompanyServices {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private VersionRepository versionRepository;


    @Autowired
    private ICompanyMapper companyMapper;

    @Override
    public CompanyExitDTO createCompany(CompanyEntryDTO companyEntryDTO) {
        companyRepository.findByCompanyCode(
                companyEntryDTO.getCompanyCode()).ifPresent(c -> { throw new AlreadyExistsException("Company already exists");});

        Version version = versionRepository.findByApplicationAppCodeAndVersion(
                companyEntryDTO.getAppCode(), companyEntryDTO.getVersion()).orElseThrow(() -> new NotFoundException("Version not found"));

        Company company = companyMapper.mapperCompanyEntryToCompany(companyEntryDTO, version);

        companyRepository.save(company);

        return companyMapper.mapCompanyToCompanyExit(company);
    }

    @Override
    public List<CompanyExitDTO> getAllCompany() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().distinct().map(companyMapper::mapCompanyToCompanyExit) .collect(Collectors.toList());
    }

    @Override
    public CompanyExitDTO getCompanyByCode(String code) {
        Company company = companyRepository.findByCompanyCode(code).orElseThrow(() -> new NotFoundException("Company not found"));
        return companyMapper.mapCompanyToCompanyExit(company);
    }

    @Override
    public CompanyExitDTO updateCompany(CompanyEntryDTO companyEntryDTO) {
        Company company = companyRepository.findByCompanyCode(
                companyEntryDTO.getCompanyCode()).orElseThrow(() -> new NotFoundException("Company not found"));

        Version version = versionRepository.findByApplicationAppCodeAndVersion(
                companyEntryDTO.getAppCode(), companyEntryDTO.getVersion()).orElseThrow(() -> new NotFoundException("Version not found"));

        company = companyMapper.mapperCompanyEntryToCompany(companyEntryDTO, version);

        companyRepository.save(company);

        return companyMapper.mapCompanyToCompanyExit(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company not exist"));
        companyRepository.deleteById(id);
    }
}
