package com.assessment.dto.request;

import com.assessment.model.Department;
import lombok.Data;

@Data
public class EmployeeForm {

    private String firstName;
    private String lastname;
    private String emailId;
    private String phoneNumber;

    private DepartmentForm departmentForm;
}
