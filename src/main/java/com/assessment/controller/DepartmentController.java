package com.assessment.controller;

import com.assessment.constant.UrlMapping;
import com.assessment.dto.request.DepartmentForm;
import com.assessment.dto.request.EmployeeForm;
import com.assessment.service.impl.DepartmentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlMapping.DEPARTMENT)
public class DepartmentController {

    @Autowired
     private DepartmentServiceImpl departmentService;

    @PostMapping
    @ApiOperation(value = "Create new Department")
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentForm departmentForm){
        return departmentService.saveDepartment(departmentForm);
    }

    @GetMapping(UrlMapping.GET_DEPARTMENT)
    @ApiOperation(value = "Fetch all Department")
    public ResponseEntity<?> fetchDepartment(){
        return departmentService.fetchDepartment();
    }

    @GetMapping(UrlMapping.GET_DEPARTMENT_BY_ID)
    @ApiOperation(value = "Fetch Department by Id")
    public ResponseEntity<?> fetchDepartmentById(@PathVariable Long id){
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping(UrlMapping.DELETE_DEPARTMENT_BY_ID)
    @ApiOperation(value = "Delete Department by Id")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id){
        return departmentService.deleteDepartmentById(id);
    }

    @PutMapping(UrlMapping.UPDATE_DEPARTMENT)
    @ApiOperation(value = "Update Department")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody DepartmentForm departmentForm){
        return departmentService.updateDepartment(id,departmentForm);
    }
}
