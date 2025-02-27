package com.springboot.employeepayrollapp.controller;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll Service!";
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable int id) {
        EmployeePayrollDTO dto = new EmployeePayrollDTO("Lisa", 2000);
        return new EmployeePayroll(id, dto);
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@RequestBody EmployeePayrollDTO dto) {
        return new EmployeePayroll(1, dto);
    }

    @PutMapping("/update")
    public EmployeePayroll updateEmployee(@RequestBody EmployeePayrollDTO dto) {
        return new EmployeePayroll(1, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Employee with ID " + id + " deleted.";
    }
}
