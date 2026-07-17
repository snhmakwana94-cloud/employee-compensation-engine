package com.sneha.compensation.strategy;

import com.sneha.compensation.model.Employee;

public class SeniorEmployeeStrategy
        implements CompensationStrategy {

    @Override
    public double calculateBonus(Employee employee) {

        if (employee.getExperienceYears() >= 10) {
            return employee.getBaseSalary() * 0.25;
        }

        return employee.getBaseSalary() * 0.10;
    }
}