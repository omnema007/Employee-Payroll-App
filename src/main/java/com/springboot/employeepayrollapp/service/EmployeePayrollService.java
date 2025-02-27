package com.springboot.employeepayrollapp.service;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService {

    public EmployeePayroll getEmployeeById(int id) {
        EmployeePayrollDTO dto = new EmployeePayrollDTO("Lisa", 2000);
        return new EmployeePayroll(id, dto);
    }

    public EmployeePayroll createEmployee(EmployeePayrollDTO dto) {
        return new EmployeePayroll(1, dto);
    }

    public EmployeePayroll updateEmployee(EmployeePayrollDTO dto) {
        return new EmployeePayroll(1, dto);
    }

    public String deleteEmployee(int id) {
        return "Employee with ID " + id + " deleted.";
    }
}

