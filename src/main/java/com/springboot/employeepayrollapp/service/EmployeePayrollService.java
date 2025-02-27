package com.springboot.employeepayrollapp.service;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;
import com.springboot.employeepayrollapp.repository.EmployeePayrollRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayroll> getAllEmployees() {
        log.info("Fetching all employees.");
        return employeePayrollRepository.findAll();
    }

    public EmployeePayroll getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return employeePayrollRepository.findById(id).orElse(null);
    }

    public EmployeePayroll createEmployee(EmployeePayrollDTO dto) {
        EmployeePayroll employee = new EmployeePayroll(dto);
        EmployeePayroll savedEmployee = employeePayrollRepository.save(employee);
        log.info("Created Employee: {}", savedEmployee);
        return savedEmployee;
    }

    public EmployeePayroll updateEmployee(int id, EmployeePayrollDTO dto) {
        Optional<EmployeePayroll> existingEmployee = employeePayrollRepository.findById(id);
        if (existingEmployee.isPresent()) {
            EmployeePayroll employee = existingEmployee.get();
            employee.setName(dto.getName());
            employee.setSalary(dto.getSalary());
            EmployeePayroll updatedEmployee = employeePayrollRepository.save(employee);
            log.info("Updated Employee: {}", updatedEmployee);
            return updatedEmployee;
        }
        log.warn("Employee with ID {} not found for update.", id);
        return null;
    }

    public String deleteEmployee(int id) {
        if (employeePayrollRepository.existsById(id)) {
            employeePayrollRepository.deleteById(id);
            log.info("Deleted Employee with ID: {}", id);
            return "Employee with ID " + id + " deleted.";
        }
        log.warn("Employee with ID {} not found for deletion.", id);
        return "Employee not found.";
    }
}
