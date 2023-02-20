package com.assessment.dto.response;

import com.assessment.model.Company;
import lombok.Data;

@Data
public class CompanyDto {

    private Long id;
    private String companyName;
    private String location;

    public CompanyDto(Company company){
        this.id = company.getId();
        this.companyName = getCompanyName();
        this.location = getLocation();
    }
}
