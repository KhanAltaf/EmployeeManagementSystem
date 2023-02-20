package com.assessment.controller;

import com.assessment.constant.UrlMapping;
import com.assessment.dto.request.CompanyForm;
import com.assessment.service.impl.CompanyServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlMapping.COMPANY)
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @PostMapping
    @ApiOperation(value = "Create new Company")
    public ResponseEntity<?> saveCompany(@RequestBody CompanyForm companyForm){
        return companyService.saveCompany(companyForm);
    }

    @GetMapping(UrlMapping.GET_COMPANY)
    @ApiOperation(value = "Fetch all Company")
    public ResponseEntity<?> fetchCompany(){
        return companyService.fetchEmployee();
    }

    @GetMapping(UrlMapping.GET_COMPANY_BY_ID)
    @ApiOperation(value = "Fetch Company by Id")
    public ResponseEntity<?> fetchCompanyById(@PathVariable Long id){
        return companyService.fetchCompanyById(id);
    }

    @DeleteMapping(UrlMapping.DELETE_COMPANY_BY_ID)
    @ApiOperation(value = "Delete Company By Id")
    public  ResponseEntity<?> deleteCompanyById(@PathVariable Long id){
        return companyService.deleteCompanyById(id);
    }

    @PutMapping(UrlMapping.UPDATE_COMPANY)
    @ApiOperation(value = "Update Company")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody CompanyForm companyForm){
        return companyService.updateCompany(id,companyForm);
    }
}
