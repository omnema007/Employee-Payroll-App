package com.springboot.employeepayrollapp.service;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.exception.EmployeeNotFoundException;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;
import com.springboot.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

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
        return employeePayrollRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
    }

    public EmployeePayroll createEmployee(@Valid EmployeePayrollDTO dto) {
        log.info("Creating Employee: {}", dto);
        EmployeePayroll employee = new EmployeePayroll(dto);
        return employeePayrollRepository.save(employee);
    }

    public EmployeePayroll updateEmployee(int id, @Valid EmployeePayrollDTO dto) {
        log.info("Updating Employee ID: {} with data: {}", id, dto);
        EmployeePayroll employee = employeePayrollRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found."));
        employee.setName(dto.getName());
        employee.setGender(dto.getGender());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setStartDate(dto.getStartDate());
        employee.setNote(dto.getNote());
        employee.setProfilePic(dto.getProfilePic());
        return employeePayrollRepository.save(employee);
    }

    public String deleteEmployee(int id) {
        log.info("Deleting Employee ID: {}", id);
        if (!employeePayrollRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        employeePayrollRepository.deleteById(id);
        return "Employee with ID " + id + " deleted.";
    }

    public List<EmployeePayroll> getEmployeesByDepartment(String department) {
        log.info("Fetching employees from department: {}", department);
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}

