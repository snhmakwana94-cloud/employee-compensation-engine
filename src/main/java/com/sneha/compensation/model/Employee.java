package com.sneha.compensation.model;

import com.sneha.compensation.exception.InvalidEmployeeIdException;
import com.sneha.compensation.exception.InvalidEmployeeNameException;
import com.sneha.compensation.exception.InvalidExperienceException;
import com.sneha.compensation.exception.InvalidSalaryException;
import com.sneha.compensation.exception.DepartmentValidationException;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double baseSalary;
    private int experienceYears;

    // Default Constructor
    public Employee() {
        this(0, "Unknown", "Unassigned", 0.0, 0);
    }

    // Constructor 1
    public Employee(int employeeId, String name) {
        this(employeeId, name, "Unassigned", 0.0, 0);
    }

    // Constructor 2
    public Employee(
            int employeeId,
            String name,
            String department,
            double baseSalary,
            int experienceYears) {

        setEmployeeId(employeeId);
        setName(name);
        setDepartment(department);
        setBaseSalary(baseSalary);
        setExperienceYears(experienceYears);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {

        if (employeeId <= 0) {
            throw new InvalidEmployeeIdException(
                    "Employee ID must be greater than zero.");
        }

        if (employeeId > 9000) {
            throw new InvalidEmployeeIdException(
                    "Employee ID must be less than or equal to 9000.");
        }

        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new InvalidEmployeeNameException(
                    "Employee name cannot be empty.");
        }

        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {

        if (department == null || department.isBlank()) {
            throw new DepartmentValidationException(
                    "Department cannot be empty.");
        }

        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {

        if (baseSalary < 0) {
            throw new InvalidSalaryException(
                    "Salary cannot be negative.");
        }

        this.baseSalary = baseSalary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {

        if (experienceYears < 0) {
            throw new InvalidExperienceException(
                    "Experience cannot be negative.");
        }

        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {

        return String.format(
                "Employee {%n" +
                        "    employeeId=%d,%n" +
                        "    name='%s',%n" +
                        "    department='%s',%n" +
                        "    baseSalary=%.2f,%n" +
                        "    experienceYears=%d%n" +
                        "}%n",
                employeeId,
                name,
                department,
                baseSalary,
                experienceYears);
    }

    private SalaryBand salaryband;

    public SalaryBand getSalaryBand() {
        return salaryband;
    }

    public void setSalaryBand(SalaryBand salaryband) {
        this.salaryband = salaryband;
    }

    public static class SalaryBand {

        private final String level;
        private final double minSalary;
        private final double maxSalary;

        public SalaryBand(
                String level,
                double minSalary,
                double maxSalary) {

            this.level = level;
            this.minSalary = minSalary;
            this.maxSalary = maxSalary;
        }

        public String getLevel() {
            return level;
        }

        public double getMinSalary() {
            return minSalary;
        }

        public double getMaxSalary() {
            return maxSalary;
        }

        public boolean isSalaryWithinBand(double salary) {
            return salary >= minSalary && salary <= maxSalary;
        }

        @Override
        public String toString() {

            return String.format(
                    "SalaryBand {%n" +
                            "    level='%s',%n" +
                            "    minSalary=%.2f,%n" +
                            "    maxSalary=%.2f%n" +
                            "}%n",
                    level,
                    minSalary,
                    maxSalary);
        }
    }

}
