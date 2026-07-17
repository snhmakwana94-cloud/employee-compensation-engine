package com.sneha.compensation.strategy;

import com.sneha.compensation.model.Employee;

public class PercentageBonusStrategy
        implements CompensationStrategy {

    private final double percentage;

    public PercentageBonusStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateBonus(Employee employee) {

        return employee.getBaseSalary()
                * percentage
                / 100;

    }
}