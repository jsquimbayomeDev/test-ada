package com.ada.prueba.controllers.impl;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.controllers.ICompanyController;
import com.ada.prueba.services.ICompanyServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController implements ICompanyController {

    private final ICompanyServices companyServices;

    public CompanyController(ICompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    @Override
    @PostMapping
    public ResponseEntity<CompanyExitDTO> createCompany(@RequestBody CompanyEntryDTO companyEntryDTO) {
        return ResponseEntity.ok(companyServices.createCompany(companyEntryDTO));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CompanyExitDTO>> getAllCompany() {
        return ResponseEntity.ok(companyServices.getAllCompany());
    }

    @Override
    @GetMapping("/{code}")
    public ResponseEntity<CompanyExitDTO> getCompanyByCode(@PathVariable String code) {
        return ResponseEntity.ok(companyServices.getCompanyByCode(code));
    }

    @Override
    @PutMapping
    public ResponseEntity<CompanyExitDTO> updateCompany(@RequestBody CompanyEntryDTO companyEntryDTO) {
        return ResponseEntity.ok(companyServices.updateCompany(companyEntryDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String id) {
        companyServices.deleteCompany(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }
}
