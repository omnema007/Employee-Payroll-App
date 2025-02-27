package com.springboot.employeepayrollapp.controller;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;
import com.springboot.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll Service!";
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable int id) {
        return employeePayrollService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@RequestBody EmployeePayrollDTO dto) {
        return employeePayrollService.createEmployee(dto);
    }

    @PutMapping("/update")
    public EmployeePayroll updateEmployee(@RequestBody EmployeePayrollDTO dto) {
        return employeePayrollService.updateEmployee(dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeePayrollService.deleteEmployee(id);
    }
}
