package com.springboot.employeepayrollapp.controller;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;
import com.springboot.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public String getWelcomeMessage() {
        log.info("Received request for welcome message.");
        return "Welcome to Employee Payroll Service!";
    }

    @GetMapping("/getAll")
    public List<EmployeePayroll> getAllEmployees() {
        log.info("Received request to fetch all employees.");
        return employeePayrollService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable int id) {
        log.info("Received request to fetch employee with ID: {}", id);
        return employeePayrollService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@RequestBody EmployeePayrollDTO dto) {
        log.info("Received request to create employee: {}", dto);
        return employeePayrollService.createEmployee(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayroll updateEmployee(@PathVariable int id, @RequestBody EmployeePayrollDTO dto) {
        log.info("Received request to update employee ID: {} with data: {}", id, dto);
        return employeePayrollService.updateEmployee(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        log.info("Received request to delete employee with ID: {}", id);
        return employeePayrollService.deleteEmployee(id);
    }
}
