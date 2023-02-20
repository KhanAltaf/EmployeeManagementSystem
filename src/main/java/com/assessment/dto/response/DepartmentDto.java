package com.assessment.dto.response;

import com.assessment.model.Department;
import lombok.Data;

@Data
public class DepartmentDto {

    private Long id;
    private String departmentName;

    public DepartmentDto(Department department){
        this.id = department.getId();
        this.departmentName = department.getDepartmentName();
    }
}
