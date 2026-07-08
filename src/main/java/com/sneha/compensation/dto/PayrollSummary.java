package com.sneha.compensation.dto;

public record PayrollSummary(

        int employeeId,

        String employeeName,

        double annualSalary,

        double monthlySalary) {
}