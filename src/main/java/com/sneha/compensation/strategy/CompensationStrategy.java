package com.sneha.compensation.strategy;

import com.sneha.compensation.model.Employee;

@FunctionalInterface
public interface CompensationStrategy {

    double calculateBonus(Employee employee);

}