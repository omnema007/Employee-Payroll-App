package com.springboot.employeepayrollapp.controller;
import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.validation.Valid;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;
import com.springboot.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

//    @PostMapping("/create")
//    public EmployeePayroll createEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
//        log.info("Received request to create employee: {}", dto);
//        return employeePayrollService.createEmployee(dto);
//    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
        return employeePayrollService.createEmployee(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayroll updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        log.info("Received request to update employee ID: {} with data: {}", id, dto);
        return employeePayrollService.updateEmployee(id, dto);
    }
}

