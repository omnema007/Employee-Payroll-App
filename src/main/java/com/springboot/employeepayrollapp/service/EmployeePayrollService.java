package com.springboot.employeepayrollapp.service;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    private final List<EmployeePayroll> employeeList = new ArrayList<>();
    private int idCounter = 1;

    public List<EmployeePayroll> getAllEmployees() {
        return employeeList;
    }

    public EmployeePayroll getEmployeeById(int id) {
        Optional<EmployeePayroll> employee = employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
        return employee.orElse(null);
    }

    public EmployeePayroll createEmployee(EmployeePayrollDTO dto) {
        EmployeePayroll employee = new EmployeePayroll(idCounter++, dto);
        employeeList.add(employee);
        return employee;
    }

    public EmployeePayroll updateEmployee(int id, EmployeePayrollDTO dto) {
        for (EmployeePayroll employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                EmployeePayroll updatedEmployee = new EmployeePayroll(id, dto);
                employeeList.add(updatedEmployee);
                return updatedEmployee;
            }
        }
        return null;
    }

    public String deleteEmployee(int id) {
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);
        return removed ? "Employee with ID " + id + " deleted." : "Employee not found.";
    }
}


