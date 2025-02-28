package com.springboot.employeepayrollapp.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollDTO {
    private String name;
    private String gender;
    private List<String> department;
    private double salary;
    private LocalDate startDate;
    private String note;
    private String profilePic;
}


