package com.assessment.model;

import com.assessment.dto.request.CompanyForm;
import com.assessment.dto.request.DepartmentForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private List<Department> department;
    private String companyName;
    private String location;

    public Company(CompanyForm companyForm){
        this.companyName = companyForm.getCompanyName();
        this.location = companyForm.getLocation();
    }

    public Company(CompanyForm companyForm, Long id) {
        this.id = id;
        this.companyName = companyForm.getCompanyName();
        this.location = companyForm.getLocation();
    }

    public List<Department> getDepartment(List<DepartmentForm> departmentForms){
        List<Department> departmentList = new ArrayList<>();
        if(departmentForms != null){
            for(DepartmentForm departmentForm : departmentForms){
                Department department = new Department(null, departmentForm.getDepartmentName());
                departmentList.add(department);
            }
        }
        return departmentList;
    }
}
