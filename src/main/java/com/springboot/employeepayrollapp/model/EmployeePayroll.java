package com.springboot.employeepayrollapp.model;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;

public class EmployeePayroll {
    private int id;
    private String name;
    private double salary;

    public EmployeePayroll(int id, EmployeePayrollDTO dto) {
        this.id = id;
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
}

