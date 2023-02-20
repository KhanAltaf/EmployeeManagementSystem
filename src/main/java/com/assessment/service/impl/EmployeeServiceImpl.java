package com.assessment.service.impl;

import com.assessment.dto.request.EmployeeForm;
import com.assessment.model.Employee;
import com.assessment.repository.EmployeeRepository;
import com.assessment.service.EmployeeService;
import com.assessment.util.CustomResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public CustomResponseEntity saveEmployee(EmployeeForm employeeForm) {
        Map<String, Object> map = new HashMap<>();
        try {
            Employee employee = new Employee(employeeForm);
            employeeRepository.save(employee);
            map.put("Message: ", "Employee saved successfully");
            map.put("Id", employee.getId());
            return new  CustomResponseEntity(map, HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occur saving Employee",e);
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomResponseEntity fetchEmployee() {
        try {
            return new CustomResponseEntity(employeeRepository.findAll(),HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occur while fetching the Employee");
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomResponseEntity fetchEmployeeById(Long id) {
        try {
            System.out.println("Fetched from database");
            return new CustomResponseEntity(employeeRepository.findById(id),HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occur while fetching Employee",e);
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomResponseEntity deleteEmployeeById(Long id) {
        try {
            employeeRepository.deleteById(id);
            return new CustomResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occur while deleting Employee");
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomResponseEntity updateEmployee(Long id, EmployeeForm employeeForm) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            if (employee.isPresent()){

                Employee update = new Employee(id,employeeForm);
                employeeRepository.save(update);
            }
            return new CustomResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occur while updating Employee");
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomResponseEntity findByEmailAddress(String emailAddress) {
        try {
            return new CustomResponseEntity(employeeRepository.findByEmailAddress(emailAddress),HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occur while fetching Employee using Email Address",e);
            return new CustomResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
