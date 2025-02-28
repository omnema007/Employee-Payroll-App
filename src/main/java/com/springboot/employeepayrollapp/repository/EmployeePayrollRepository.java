package com.springboot.employeepayrollapp.repository;

import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Integer> {
    // CRUD methods will be automatically provided by Spring Data JPA
}

