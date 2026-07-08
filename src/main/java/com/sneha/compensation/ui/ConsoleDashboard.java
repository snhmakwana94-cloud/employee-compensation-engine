package com.sneha.compensation.ui;

import java.util.List;
import java.util.Scanner;

import com.sneha.compensation.dto.AnalyticsReport;
import com.sneha.compensation.dto.PayrollSummary;
import com.sneha.compensation.model.Employee;
import com.sneha.compensation.service.EmployeeService;

public class ConsoleDashboard {

    private final Scanner scanner = new Scanner(System.in);

    private static final String MENU = """
            =========================================
             Employee Compensation Intelligence Engine
            =========================================

            1. Register Employee
            2. View Employees
            3. Search Employee
            4. Delete Employee
            5. Analytics
            6. Payroll Summary
            7. Exit

            Choose an option:
            """;

    public void displayMenu() {
        System.out.println(MENU);
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public int readEmployeeId() {

        System.out.print("Enter Employee ID : ");
        return scanner.nextInt();
    }

    public String readEmployeeName() {

        scanner.nextLine();

        System.out.print("Enter Employee Name : ");

        return scanner.nextLine();
    }

    public String readDepartment() {

        System.out.print("Enter Department : ");

        return scanner.nextLine();
    }

    public double readSalary() {

        System.out.print("Enter Base Salary : ");

        return scanner.nextDouble();
    }

    public int readExperienceYears() {

        System.out.print("Enter Years of Experience : ");

        return scanner.nextInt();
    }

    public void displayEmployees(List<Employee> employees) {

        if (employees.isEmpty()) {

            System.out.println();
            System.out.println("No employees found.");
            return;
        }

        System.out.println();

        for (Employee employee : employees) {

            displayEmployee(employee);

        }

        System.out.println("----------------------------------------");
    }

    public void displayEmployee(Employee employee) {

        System.out.println("----------------------------------------");

        System.out.printf(
                "Employee ID : %d%n",
                employee.getEmployeeId());

        System.out.printf(
                "Name        : %s%n",
                employee.getName());

        System.out.printf(
                "Department  : %s%n",
                employee.getDepartment());

        System.out.printf(
                "Salary      : %.2f%n",
                employee.getBaseSalary());

        System.out.printf(
                "Experience  : %d Years%n",
                employee.getExperienceYears());

        System.out.println("----------------------------------------");
    }

    private void printEmployee(Employee employee) {

        System.out.println("----------------------------------------");
        System.out.printf("Employee ID : %d%n", employee.getEmployeeId());
        System.out.printf("Name        : %s%n", employee.getName());
        System.out.printf("Department  : %s%n", employee.getDepartment());
        System.out.printf("Salary      : %.2f%n", employee.getBaseSalary());
        System.out.printf("Experience  : %d Years%n", employee.getExperienceYears());
        System.out.println("----------------------------------------");
    }

    public int readSearchEmployeeId() {

        System.out.print("Enter Employee ID : ");

        return scanner.nextInt();

    }

    public boolean confirmDeletion() {

        scanner.nextLine(); // consume leftover newline if needed

        System.out.print("Are you sure you want to delete this employee? (Y/N): ");

        String response = scanner.nextLine();

        return response.equalsIgnoreCase("Y");
    }

    public void displayAnalytics(
            AnalyticsReport report) {

        System.out.println();
        System.out.println("=========================================");
        System.out.println(" Employee Analytics");
        System.out.println("=========================================");

        System.out.printf(
                "Total Employees      : %d%n",
                report.totalEmployees());

        System.out.printf(
                "Total Payroll        : %.2f%n",
                report.totalPayroll());

        System.out.printf(
                "Average Salary       : %.2f%n",
                report.averageSalary());

        if (report.highestPaidEmployee() != null) {

            System.out.printf(
                    "Highest Paid Employee: %s (%.2f)%n",

                    report.highestPaidEmployee().getName(),

                    report.highestPaidEmployee().getBaseSalary());
        }

        if (report.lowestPaidEmployee() != null) {

            System.out.printf(
                    "Lowest Paid Employee : %s (%.2f)%n",

                    report.lowestPaidEmployee().getName(),

                    report.lowestPaidEmployee().getBaseSalary());
        }

        System.out.println("=========================================");
    }

    public void displayPayrollSummary(
            List<PayrollSummary> payrollList) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           PAYROLL SUMMARY");
        System.out.println("==========================================");

        payrollList.forEach(summary -> {

            System.out.printf("Employee ID   : %d%n",
                    summary.employeeId());

            System.out.printf("Employee Name : %s%n",
                    summary.employeeName());

            System.out.printf("Annual Salary : %.2f%n",
                    summary.annualSalary());

            System.out.printf("Monthly Salary: %.2f%n",
                    summary.monthlySalary());

            System.out.println("------------------------------------------");
        });

    }
}