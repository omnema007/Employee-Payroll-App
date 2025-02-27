package com.springboot.employeepayrollapp.controller;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;
import com.springboot.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll Service!";
    }

    @GetMapping("/getAll")
    public List<EmployeePayroll> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable int id) {
        return employeePayrollService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@RequestBody EmployeePayrollDTO dto) {
        return employeePayrollService.createEmployee(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayroll updateEmployee(@PathVariable int id, @RequestBody EmployeePayrollDTO dto) {
        return employeePayrollService.updateEmployee(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeePayrollService.deleteEmployee(id);
    }
}
