package com.sneha.compensation.dto;

import com.sneha.compensation.model.Employee;

public record AnalyticsReport(

        long totalEmployees,

        double totalPayroll,

        double averageSalary,

        Employee highestPaidEmployee,

        Employee lowestPaidEmployee

) {

}