package com.springboot.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll Service!";
    }

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable int id) {
        return "Fetching employee with ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody String employeeData) {
        return "Employee Created: " + employeeData;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employeeData) {
        return "Employee Updated: " + employeeData;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Employee with ID " + id + " deleted.";
    }
}

