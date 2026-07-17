package com.sneha.compensation.service;

import com.sneha.compensation.model.Employee;
import com.sneha.compensation.strategy.CompensationStrategy;

public final class CompensationCalculator {

    private final CompensationStrategy strategy;

    public CompensationCalculator(
            CompensationStrategy strategy) {

        this.strategy = strategy;

    }

    /*
     * Bonus based only on salary
     */
    public static double calculateBonus(double salary) {

        return salary * 0.05;
    }

    /*
     * Bonus based on salary and rating
     */
    public static double calculateBonus(
            double salary,
            int rating) {

        return salary * (rating * 0.02);
    }

    /*
     * Bonus based on salary, rating and experience
     */
    public static double calculateBonus(
            double salary,
            int rating,
            int experienceYears) {

        return salary *
                ((rating * 0.02)
                        + (experienceYears * 0.005));
    }

    public static double calculateBonus(Employee employee, int extraAmount) {
        return employee.getBaseSalary() *
                ((employee.getExperienceYears() * 0.005)
                        + (employee.getExperienceYears() * 0.02))
                + extraAmount;
    }

    public static double calculateBonus(Employee employee) {
        return calculateBonus(
                employee.getBaseSalary(),
                3,
                employee.getExperienceYears());
    }

    public static double calculateAverageBonus(double... bonuses) {

        if (bonuses.length == 0) {
            return 0;
        }

        double total = 0;

        for (double bonus : bonuses) {
            total += bonus;
        }

        return total / bonuses.length;
    }

    public double calculateBonusUsingStrategy(
            Employee employee) {

        return strategy.calculateBonus(employee);

    }
}