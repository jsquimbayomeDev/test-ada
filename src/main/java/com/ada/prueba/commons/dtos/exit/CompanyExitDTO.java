package com.ada.prueba.commons.dtos.exit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyExitDTO {

    private Long id;
    private String companyCode;
    private String companyName;
    private String companyDescription;
    private String appName;
    private String version;
}
