package com.sneha.compensation.strategy;

import com.sneha.compensation.model.Employee;

public class FixedBonusStrategy
        implements CompensationStrategy {

    private final double bonusAmount;

    public FixedBonusStrategy(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    @Override
    public double calculateBonus(Employee employee) {

        return bonusAmount;

    }
}