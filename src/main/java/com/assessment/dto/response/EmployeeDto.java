package com.assessment.dto.response;

import com.assessment.model.Employee;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;

    public EmployeeDto(Employee employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.emailId = employee.getEmailId();
        this.phoneNumber = employee.getPhoneNumber();
    }

}
