package com.assessment.repository;

import com.assessment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employee where email_id = ?1", nativeQuery = true)
    Employee findByEmailAddress(String emailAddress);
}
