package com.springboot.employeepayrollapp.model;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "employee_payroll")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;

    public EmployeePayroll() {}

    public EmployeePayroll(EmployeePayrollDTO dto) {
        this.name = dto.name;
        this.salary = dto.salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


