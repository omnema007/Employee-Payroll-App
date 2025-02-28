package com.springboot.employeepayrollapp.controller;
import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.validation.Valid;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;
import com.springboot.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

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
    public EmployeePayroll createEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
        log.info("Received request to create employee: {}", dto);
        return employeePayrollService.createEmployee(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayroll updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        log.info("Received request to update employee ID: {} with data: {}", id, dto);
        return employeePayrollService.updateEmployee(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        log.info("Received request to delete employee with ID: {}", id);
        return employeePayrollService.deleteEmployee(id);
    }
}


