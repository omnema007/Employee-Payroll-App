package com.springboot.employeepayrollapp.repository;

import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, Integer> {

    @Query("SELECT e FROM EmployeePayroll e WHERE :department MEMBER OF e.department")
    List<EmployeePayroll> findEmployeesByDepartment(String department);
}


