package com.assessment.service.impl;

import com.assessment.dto.request.CompanyForm;
import com.assessment.model.Company;
import com.assessment.repository.CompanyRepository;
import com.assessment.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ResponseEntity<?> saveCompany(CompanyForm companyForm) {
        Map<String, Object> map = new HashMap<>();
        try {
            Company company = new Company(companyForm);
            company.setDepartment(company.getDepartment(companyForm.getDepartmentForms()));
            companyRepository.save(company);
            map.put("Message: ","Company saved Successfully");
            map.put("Id: ", company.getId());
            return ResponseEntity.ok(map);
        }catch (Exception e){
            log.error("Exception occur while saving the Company",e);
            return ResponseEntity.badRequest().body("Unable to save Company");
        }
    }

    @Override
    public ResponseEntity<?> fetchEmployee() {
        try {
            return ResponseEntity.ok(companyRepository.findAll());
        }catch (Exception e){
            log.error("Exception Occur while fetching data", e);
            return ResponseEntity.badRequest().body("Unable to fetch data");
        }
    }

    @Override
    public ResponseEntity<?> fetchCompanyById(Long id) {
        try {
            return ResponseEntity.ok(companyRepository.findById(id));
        }catch (Exception e){
            log.error("Exception occur while fetching data by Id",e);
            return ResponseEntity.badRequest().body("Unable to fetch data by id");
        }
    }

    @Override
    public ResponseEntity<?> deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return ResponseEntity.ok("Company deleted successfully");
        }catch (Exception e){
            log.error("Exception occur while deleting company",e);
            return ResponseEntity.badRequest().body("Unable to delete Company");
        }
    }

    @Override
    public ResponseEntity<?> updateCompany(Long id, CompanyForm companyForm) {
        try {

            Optional<Company> company = companyRepository.findById(id);
            if(company.isPresent()){
                Company update = new Company(companyForm,id);
                companyRepository.save(update);
            }else {
                throw new RuntimeException("Data not found");
            }

            return ResponseEntity.ok("Company updated successfully");
        }catch (Exception e){
            log.error("Exception occur while updating company",e);
            return ResponseEntity.badRequest().body("Unable to update Company");
        }
    }
}
