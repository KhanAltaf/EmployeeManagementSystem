package com.assessment.service;

import com.assessment.dto.request.CompanyForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    ResponseEntity<?> saveCompany(CompanyForm companyForm);

    ResponseEntity<?> fetchEmployee();

    ResponseEntity<?> fetchCompanyById(Long id);

    ResponseEntity<?> deleteCompanyById(Long id);

    ResponseEntity<?> updateCompany(Long id, CompanyForm companyForm);
}
