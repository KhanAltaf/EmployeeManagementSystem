package com.assessment.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CompanyForm {

    private String companyName;
    private String location;

    private List<DepartmentForm> departmentForms;
}
