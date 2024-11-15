package com.ada.prueba.commons.dtos.entry;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CompanyEntryDTO {


    @NotNull
    @Min(1)
    private String companyCode;

    @NotNull
    @Min(3)
    private String companyName;

    @NotNull
    private String companyDescription;
}
