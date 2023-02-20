package com.assessment.service;

import com.assessment.dto.request.DepartmentForm;
import com.assessment.dto.request.EmployeeForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    ResponseEntity<?> saveDepartment(DepartmentForm departmentForm);

    ResponseEntity<?> fetchDepartment();

    ResponseEntity<?> fetchDepartmentById(Long id);

    ResponseEntity<?> deleteDepartmentById(Long id);

    ResponseEntity<?> updateDepartment(Long id, DepartmentForm departmentForm);
}
