package com.assessment.controller;

import com.assessment.constant.UrlMapping;
import com.assessment.dto.request.EmployeeForm;
import com.assessment.service.impl.EmployeeServiceImpl;
import com.assessment.util.CustomResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(UrlMapping.EMPLOYEE)
@Api(produces = "application/json", value = "Employee Management System")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping()
    @ApiOperation(value = "Create new Employee")
    public CustomResponseEntity saveEmployee(@Valid @RequestBody EmployeeForm employeeForm){
        return employeeService.saveEmployee(employeeForm);
    }


    @GetMapping(UrlMapping.GET_EMPLOYEE)
    @ApiOperation(value = "Fetch all Employee")
    public ResponseEntity<?> fetchEmployee(){
        return employeeService.fetchEmployee();
    }

    @GetMapping(UrlMapping.GET_EMPLOYEE_BY_ID)
    @ApiOperation(value = "Fetch Employee by Id")
    public CustomResponseEntity fetchEmployeeById(@PathVariable Long id){
        return employeeService.fetchEmployeeById(id);
    }

    @DeleteMapping(UrlMapping.DELETE_EMPLOYEE_BY_ID)
    @ApiOperation(value = "Delete Employee by Id")
    public  CustomResponseEntity deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping(UrlMapping.UPDATE_EMPLOYEE)
    @ApiOperation(value = "Update Employee")
    public CustomResponseEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeForm employeeForm){
        return employeeService.updateEmployee(id,employeeForm);
    }

    @GetMapping
    @ApiOperation(value = "Get Employee using Email Id")
    public CustomResponseEntity findByEmailAddress(String emailAddress){
        return employeeService.findByEmailAddress(emailAddress);
    }

}
