package com.assessment.service;

import com.assessment.dto.request.CompanyForm;
import com.assessment.dto.request.EmployeeForm;
import com.assessment.util.CustomResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    CustomResponseEntity saveEmployee(EmployeeForm employeeForm);

    CustomResponseEntity fetchEmployee();

    CustomResponseEntity fetchEmployeeById(Long id);

    CustomResponseEntity deleteEmployeeById(Long id);

    CustomResponseEntity updateEmployee(Long id, EmployeeForm employeeForm);

    CustomResponseEntity findByEmailAddress(String emailAddress);
}
