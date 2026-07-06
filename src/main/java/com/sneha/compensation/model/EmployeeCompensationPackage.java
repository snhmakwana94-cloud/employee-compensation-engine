package com.sneha.compensation.model;

public final class EmployeeCompensationPackage {

    private final int employeeId;
    private final String employeeName;
    private final double baseSalary;
    private final double annualBonus;

    public EmployeeCompensationPackage(
            int employeeId,
            String employeeName,
            double baseSalary,
            double annualBonus) {

        if (employeeId <= 0) {
            throw new IllegalArgumentException(
                    "Employee id must be positive");
        }

        if (employeeName == null
                || employeeName.isBlank()) {

            throw new IllegalArgumentException(
                    "Employee name required");
        }

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.baseSalary = baseSalary;
        this.annualBonus = annualBonus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public double getTotalCompensation() {
        return baseSalary + annualBonus;
    }

    @Override
    public String toString() {
        return """
                CompensationPackage{
                    employeeId=%d,
                    employeeName='%s',
                    baseSalary=%.2f,
                    annualBonus=%.2f,
                    totalCompensation=%.2f
                }
                """.formatted(
                employeeId,
                employeeName,
                baseSalary,
                annualBonus,
                getTotalCompensation());
    }
}