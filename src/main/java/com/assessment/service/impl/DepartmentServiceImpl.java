package com.assessment.service.impl;

import com.assessment.dto.request.DepartmentForm;
import com.assessment.dto.request.EmployeeForm;
import com.assessment.model.Department;
import com.assessment.repository.DepartmentRepository;
import com.assessment.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public ResponseEntity<?> saveDepartment(DepartmentForm departmentForm) {
        Map<String,Object> map = new HashMap<>();
        try {
            Department department = new Department(departmentForm);
            departmentRepository.save(department);
            map.put("Message", "Department saved Successfully");
            map.put("Id: " , department.getId());
            return ResponseEntity.ok(map);
        }catch (Exception e){
            log.error("Exception occur while saving Department",e);
            return ResponseEntity.badRequest().body("Unable to save Department");
        }
    }

    @Override
    public ResponseEntity<?> fetchDepartment() {
        try {
            return ResponseEntity.ok(departmentRepository.findAll());
        }catch (Exception e){
            log.error("Exception occur while fetching the Department");
            return ResponseEntity.badRequest().body("Unable to fetch Department");
        }
    }

    @Override
    public ResponseEntity<?> fetchDepartmentById(Long id) {
        try {
            return ResponseEntity.ok(departmentRepository.findById(id));
        }catch (Exception e){
            log.error("Exception occur while fetching Department");
            return ResponseEntity.badRequest().body("Unable to fetch the Department");
        }
    }

    @Override
    public ResponseEntity<?> deleteDepartmentById(Long id) {
        try {
            departmentRepository.deleteById(id);
            return ResponseEntity.ok("Department deleted Successfully");
        }catch (Exception e){
            log.error("Exception occur while deleting Department");
            return ResponseEntity.badRequest().body("Unable to delete Department");
        }
    }

    @Override
    public ResponseEntity<?> updateDepartment(Long id, DepartmentForm departmentForm) {
        try {
            Optional<Department> department = departmentRepository.findById(id);
            if(department.isPresent()){
                Department update = new Department(id,departmentForm);
                departmentRepository.save(update);
            }else {
                throw  new RuntimeException("Unable to update Department");
            }
            return ResponseEntity.ok("Department update Successfully");
        }catch (Exception e){
            log.error("Exception occur while updating Department");
            return ResponseEntity.badRequest().body("Unable to update Department");
        }
    }
}
