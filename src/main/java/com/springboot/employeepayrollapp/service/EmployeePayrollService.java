package com.springboot.employeepayrollapp.service;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;
import com.springboot.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public EmployeePayroll createEmployee(@Valid EmployeePayrollDTO dto) {
        log.info("Creating Employee: {}", dto);
        EmployeePayroll employee = new EmployeePayroll(dto);
        return employeePayrollRepository.save(employee);
    }

    public EmployeePayroll updateEmployee(int id, @Valid EmployeePayrollDTO dto) {
        log.info("Updating Employee ID: {} with data: {}", id, dto);
        EmployeePayroll employee = employeePayrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(dto.getName());
        employee.setGender(dto.getGender());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setStartDate(dto.getStartDate());
        employee.setNote(dto.getNote());
        employee.setProfilePic(dto.getProfilePic());
        return employeePayrollRepository.save(employee);
    }
}

