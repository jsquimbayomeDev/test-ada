package com.ada.prueba.services.impl;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.commons.exceptions.AlreadyExistsException;
import com.ada.prueba.commons.exceptions.NotFoundException;
import com.ada.prueba.mappers.ICompanyMapper;
import com.ada.prueba.domain.models.Company;
import com.ada.prueba.domain.repository.CompanyRepository;
import com.ada.prueba.services.ICompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServices implements ICompanyServices {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ICompanyMapper companyMapper;

    @Override
    public CompanyExitDTO createCompany(CompanyEntryDTO companyEntryDTO) {

        companyRepository.findByCompanyCode(
                companyEntryDTO.getCompanyCode()).ifPresent(c -> { throw  new AlreadyExistsException("company already exists");});
        Company company = companyMapper.mapperCompanyEntryToCompany(companyEntryDTO);
        companyRepository.save(company);

        return companyMapper.mapCompanyToCompanyExit(company);
    }

    @Override
    public List<CompanyExitDTO> getAllCompany() {
        List<Company> companies =  companyRepository.findAll();
        return companyMapper.mapCompanyToCompanyExitList(companies);
    }

    @Override
    public CompanyExitDTO getCompanyByCode(String code) {
        Company company =  companyRepository.findByCompanyCode(code).orElseThrow(() -> new NotFoundException("company not found"));

        return companyMapper.mapCompanyToCompanyExit(company);
    }

    @Override
    public CompanyExitDTO updateCompany(CompanyEntryDTO companyEntryDTO) {
        Company company = companyRepository.findByCompanyCode(
                companyEntryDTO.getCompanyCode()).orElseThrow(() -> new NotFoundException("company not found"));

        company = companyMapper.mapperCompanyEntryToCompany(companyEntryDTO);
        companyRepository.save(company);

        return companyMapper.mapCompanyToCompanyExit(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.findById(id).orElseThrow(() -> new NotFoundException("company not exist"));
        companyRepository.deleteById(id);
    }
}
