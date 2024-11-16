package com.ada.prueba;

import com.ada.prueba.commons.dtos.entry.CompanyEntryDTO;
import com.ada.prueba.commons.dtos.exit.CompanyExitDTO;
import com.ada.prueba.controllers.impl.CompanyController;
import com.ada.prueba.services.ICompanyServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CompanyControllerTest {

    @Mock
    private ICompanyServices companyServices;

    @InjectMocks
    private CompanyController companyController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }

    @Test
    public void testCreateCompany() throws Exception {
        CompanyEntryDTO entryDTO = new CompanyEntryDTO("COMP001", "CompanyName", "CompanyDescription", "APP001", "1.0.0");
        CompanyExitDTO exitDTO = new CompanyExitDTO(1L, "COMP001", "CompanyName", "CompanyDescription", "MyApp", "1.0.0");

        when(companyServices.createCompany(any(CompanyEntryDTO.class))).thenReturn(exitDTO);

        mockMvc.perform(post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"companyCode\":\"COMP001\",\"companyName\":\"CompanyName\",\"companyDescription\":\"CompanyDescription\",\"appCode\":\"APP001\",\"version\":\"1.0.0\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyCode").value("COMP001"))
                .andExpect(jsonPath("$.companyName").value("CompanyName"))
                .andExpect(jsonPath("$.companyDescription").value("CompanyDescription"))
                .andExpect(jsonPath("$.appName").value("MyApp"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    public void testGetAllCompany() throws Exception {
        List<CompanyExitDTO> companies = Arrays.asList(
                new CompanyExitDTO(1L, "COMP001", "CompanyName1", "Description1", "MyApp", "1.0.0"),
                new CompanyExitDTO(2L, "COMP002", "CompanyName2", "Description2", "MyApp", "1.0.0")
        );

        when(companyServices.getAllCompany()).thenReturn(companies);

        mockMvc.perform(get("/company"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].companyCode").value("COMP001"))
                .andExpect(jsonPath("$[1].companyCode").value("COMP002"));
    }

    @Test
    public void testGetCompanyByCode() throws Exception {
        CompanyExitDTO exitDTO = new CompanyExitDTO(1L, "COMP001", "CompanyName", "Description", "MyApp", "1.0.0");

        when(companyServices.getCompanyByCode(anyString())).thenReturn(exitDTO);

        mockMvc.perform(get("/company/COMP001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyCode").value("COMP001"))
                .andExpect(jsonPath("$.companyName").value("CompanyName"))
                .andExpect(jsonPath("$.companyDescription").value("Description"))
                .andExpect(jsonPath("$.appName").value("MyApp"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    public void testUpdateCompany() throws Exception {
        CompanyEntryDTO entryDTO = new CompanyEntryDTO("COMP001", "UpdatedName", "UpdatedDescription", "APP001", "1.0.0");
        CompanyExitDTO exitDTO = new CompanyExitDTO(1L, "COMP001", "UpdatedName", "UpdatedDescription", "MyApp", "1.0.0");

        when(companyServices.updateCompany(any(CompanyEntryDTO.class))).thenReturn(exitDTO);

        mockMvc.perform(put("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"companyCode\":\"COMP001\",\"companyName\":\"UpdatedName\",\"companyDescription\":\"UpdatedDescription\",\"appCode\":\"APP001\",\"version\":\"1.0.0\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyCode").value("COMP001"))
                .andExpect(jsonPath("$.companyName").value("UpdatedName"))
                .andExpect(jsonPath("$.companyDescription").value("UpdatedDescription"))
                .andExpect(jsonPath("$.appName").value("MyApp"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    public void testDeleteCompany() throws Exception {
        mockMvc.perform(delete("/company/1"))
                .andExpect(status().isNoContent());
    }
}
