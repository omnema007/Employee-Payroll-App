package com.springboot.employeepayrollapp.service;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import com.springboot.employeepayrollapp.model.EmployeePayroll;
import org.springframework.stereotype.Service;
import com.springboot.employeepayrollapp.repository.EmployeePayrollRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayroll> getAllEmployees() {
        return employeePayrollRepository.findAll();
    }

    public EmployeePayroll getEmployeeById(int id) {
        return employeePayrollRepository.findById(id).orElse(null);
    }

    public EmployeePayroll createEmployee(EmployeePayrollDTO dto) {
        EmployeePayroll employee = new EmployeePayroll(dto);
        return employeePayrollRepository.save(employee);
    }

    public EmployeePayroll updateEmployee(int id, EmployeePayrollDTO dto) {
        Optional<EmployeePayroll> existingEmployee = employeePayrollRepository.findById(id);
        if (existingEmployee.isPresent()) {
            EmployeePayroll employee = existingEmployee.get();
            employee.setName(dto.getName());
            employee.setSalary(dto.getSalary());
            return employeePayrollRepository.save(employee);
        }
        return null;
    }

    public String deleteEmployee(int id) {
        if (employeePayrollRepository.existsById(id)) {
            employeePayrollRepository.deleteById(id);
            return "Employee with ID " + id + " deleted.";
        }
        return "Employee not found.";
    }
}
