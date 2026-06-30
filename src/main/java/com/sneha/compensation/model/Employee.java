package com.sneha.compensation.model;

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
            throw new IllegalArgumentException(
                    "Employee ID must be greater than zero.");
        }

        if (employeeId > 9000) {
            throw new IllegalArgumentException(
                    "Employee ID must be less than or equal to 9000.");
        }

        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Employee name cannot be empty.");
        }

        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {

        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException(
                    "Department cannot be empty.");
        }

        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {

        if (baseSalary < 0) {
            throw new IllegalArgumentException(
                    "Salary cannot be negative.");
        }

        this.baseSalary = baseSalary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {

        if (experienceYears < 0) {
            throw new IllegalArgumentException(
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
}