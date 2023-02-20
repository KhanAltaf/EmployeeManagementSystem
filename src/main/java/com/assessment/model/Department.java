package com.assessment.model;

import com.assessment.dto.request.DepartmentForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String departmentName;

    public Department(DepartmentForm departmentForm){
        this.departmentName = departmentForm.getDepartmentName();
    }

    public Department(Long id, DepartmentForm departmentForm){
        this.id = id;
        this.departmentName = departmentForm.getDepartmentName();
    }
}
