package com.springboot.employeepayrollapp.model;

import com.springboot.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_payroll")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;

    public EmployeePayroll(EmployeePayrollDTO dto) {
        this.name = dto.getName();
        this.salary = dto.getSalary();
    }
}


