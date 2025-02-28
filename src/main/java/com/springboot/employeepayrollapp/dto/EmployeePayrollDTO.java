package com.springboot.employeepayrollapp.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Invalid name format. Name must start with an uppercase letter and have at least 3 characters.")
    private String name;

    @NotNull(message = "Gender is required")
    @Pattern(regexp = "male|female", message = "Gender must be either male or female")
    private String gender;

    @NotNull(message = "Department cannot be null")
    @Size(min = 1, message = "At least one department must be specified")
    private List<String> department;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private double salary;

    @NotNull(message = "Start date cannot be null")
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date must be a past or present date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    private String note;

    @NotBlank(message = "Profile picture cannot be blank")
    private String profilePic;
}



