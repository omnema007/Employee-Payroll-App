package com.springboot.employeepayrollapp.service;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;
import com.springboot.employeepayrollapp.repository.EmployeePayrollRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.employeepayrollapp.exception.EmployeeNotFoundException;




@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayroll> getAllEmployees() {
        return employeePayrollRepository.findAll();
    }

    public EmployeePayroll getEmployeeById(int id) {
        return employeePayrollRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
    }

    public EmployeePayroll updateEmployee(int id, EmployeePayrollDTO dto) {
        EmployeePayroll employee = employeePayrollRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        return employeePayrollRepository.save(employee);
    }

    public String deleteEmployee(int id) {
        if (!employeePayrollRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        employeePayrollRepository.deleteById(id);
        return "Employee with ID " + id + " deleted.";
    }

    public EmployeePayroll createEmployee(EmployeePayrollDTO dto) {
        EmployeePayroll employee = new EmployeePayroll(dto);
        return employeePayrollRepository.save(employee);
    }
}

