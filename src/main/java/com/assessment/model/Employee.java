package com.assessment.model;

import com.assessment.dto.request.EmployeeForm;
import com.assessment.validation.ValidateNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Department department;

    private String firstName;
    private String lastName;


    private String emailId;

   // @ValidateNumber(message = "Invalid Mobile Number")
    private String phoneNumber;


    public Employee(EmployeeForm employeeForm){
        this.firstName = employeeForm.getFirstName();
        this.lastName = employeeForm.getLastname();
        this.emailId = employeeForm.getEmailId();
        this.phoneNumber = employeeForm.getPhoneNumber();
        this.setDepartment(new Department(employeeForm.getDepartmentForm()));
    }

    public Employee(Long id,EmployeeForm employeeForm){
        this.id = id;
        this.firstName = employeeForm.getFirstName();
        this.lastName = employeeForm.getLastname();
        this.emailId = employeeForm.getEmailId();
        this.phoneNumber = employeeForm.getPhoneNumber();
    }
}
