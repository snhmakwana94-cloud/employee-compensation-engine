package com.sneha.compensation.app;

import com.sneha.compensation.analytics.CompensationAnalytics;
import com.sneha.compensation.model.Employee;
import com.sneha.compensation.model.EmployeeRegistry;
import com.sneha.compensation.model.EmployeeCompensationPackage;
import com.sneha.compensation.service.CompensationCalculator;
import com.sneha.compensation.recordmodel.BonusResult;
import com.sneha.compensation.recordmodel.CompensationReport;
import com.sneha.compensation.repository.EmployeeRepository;
import com.sneha.compensation.repository.FileEmployeeRepository;

import java.util.Optional;

public class CompensationApplication {
        public static void main(String[] args) {

                // 1. Method overloading examples
                double bonus1 = CompensationCalculator.calculateBonus(100000);

                double bonus2 = CompensationCalculator.calculateBonus(
                                100000,
                                4);

                double bonus3 = CompensationCalculator.calculateBonus(
                                100000,
                                4,
                                8);

                double bonus4 = CompensationCalculator.calculateBonus(
                                new Employee(1001, "Sneha", "IT", 50000.0, 5),
                                1000);

                double bonus5 = CompensationCalculator.calculateBonus(
                                new Employee(1001, "Sneha", "IT", 50000.0, 5));

                System.out.println("Bonus 1 = " + bonus1);
                System.out.println("Bonus 2 = " + bonus2);
                System.out.println("Bonus 3 = " + bonus3);
                System.out.println("Bonus 4 = " + bonus4);
                System.out.println("Bonus 5 = " + bonus5);

                System.out.println("AVERAGE BONUS = ");
                double averageSalary = CompensationCalculator.calculateAverageBonus(bonus1, bonus2, bonus3, bonus4,
                                bonus5);
                System.out.println(averageSalary);

                // end of method overloading examples

                // ########################################################################//

                // 2. Code to test EmployeeRegistry and Employee classes

                EmployeeRegistry registory = new EmployeeRegistry("Hr Department");

                Employee emp1 = new Employee(1001, "Sneha", "IT", 50000.0, 5);
                Employee emp2 = new Employee(1002, "John", "Finance", 60000.0, 7);
                Employee emp3 = new Employee(1003, "Alice", "HR", 55000.0, 4);

                EmployeeRegistry.registerEmployeeIntoList(emp1);
                EmployeeRegistry.registerEmployeeIntoList(emp2);
                EmployeeRegistry.registerEmployeeIntoList(emp3);

                System.out.println("Registry Name: " + registory.getRegistryName());
                System.out.println("Total Employees: " +
                                EmployeeRegistry.getTotalEmployees());
                System.out.println("Employee List: ");

                EmployeeRegistry registory1 = new EmployeeRegistry("Sales Department");
                System.out.println("Registry Name: " + registory1.getRegistryName());

                for (Employee emp : EmployeeRegistry.getAllEmployees()) {
                        System.out.println(emp);
                }

                // end of EmployeeRegistry and Employee classes test code

                // 3. nested class example

                Employee.SalaryBand juniorBand = new Employee.SalaryBand("Junior", 30000, 50000);
                Employee.SalaryBand seniorBand = new Employee.SalaryBand("Senior", 60000, 100000);

                System.out.println("Junior Band: " + juniorBand);
                System.out.println("Senior Band: " + seniorBand);

                Boolean salaryToCheck = seniorBand.isSalaryWithinBand(120000);
                System.out.println("Is salary within senior band? " + salaryToCheck);

                emp1.setSalaryBand(juniorBand);
                emp2.setSalaryBand(seniorBand);
                emp3.setSalaryBand(seniorBand);

                System.out.println("Employee 1 Salary Band: " + emp1.getSalaryBand());
                System.out.println("Employee 2 Salary Band: " + emp2.getSalaryBand());
                System.out.println("Employee 3 Salary Band: " + emp3.getSalaryBand());

                // end of nested class example

                // 4. record class example
                CompensationReport report = new CompensationReport(
                                emp1.getEmployeeId(),
                                emp1.getName(),
                                emp1.getBaseSalary(),
                                bonus4,
                                emp1.getBaseSalary() + bonus4);

                CompensationReport report2 = new CompensationReport(
                                emp2.getEmployeeId(),
                                emp2.getName(),
                                emp2.getBaseSalary(),
                                bonus4,
                                emp2.getBaseSalary() + bonus4);

                System.out.println("Compensation Report: " + report);
                System.out.println("Compensation Report: " + report2);
                System.out.println(report.employeeName());
                System.out.println(report.totalCompensation());

                // bonus calculation record example

                BonusResult result = new BonusResult(15000, "HIGH_PERFORMER");
                System.out.println(result);

                // end of record class example

                // 5. final class example
                EmployeeCompensationPackage package1 = new EmployeeCompensationPackage(
                                emp1.getEmployeeId(),
                                emp1.getName(),
                                emp1.getBaseSalary(),
                                bonus4);

                System.out.println("Employee Compensation Package: " + package1);

                // end of final class example

                // 6.list, arraylist, optional, and lambda expression example

                EmployeeRepository repository = new FileEmployeeRepository();
                repository.save(emp1);
                repository.save(emp2);
                repository.save(emp3);

                repository.findAll().forEach(System.out::println);

                Optional<Employee> optionalEmployee = repository.findById(1002);
                System.out.println("Found Employee: " + optionalEmployee.orElse(null));

                // end of list, arraylist, optional, and lambda expression example

                // 7. Compensation Analysis using Streams and Lambda Expressions

                CompensationAnalytics analytics = new CompensationAnalytics(repository.findAll());
                System.out.println("Employees with salary above 100000:");
                analytics.findEmployeesWithSalaryAbove(50000).forEach(System.out::println);
                System.out.println("Employees in HR department:");
                analytics.findEmployeesByDepartment("HR").forEach(System.out::println);

                System.out.println("Highest paid employee:");
                Optional<Employee> highestPaidEmployee = analytics.findHighestPaidEmployee();
                highestPaidEmployee.ifPresent(System.out::println);

                System.out.println("Lowest paid employee:");
                Optional<Employee> lowestPaidEmployee = analytics.findLowestPaidEmployee();
                lowestPaidEmployee.ifPresent(System.out::println);

                System.out.println("Average salary of employees:");
                double averageSalaryOfEmployees = analytics.calculateAverageSalary();
                System.out.println(averageSalaryOfEmployees);

                System.out.println("Total salary of employees:");
                double totalSalaryOfEmployees = analytics.calculateTotalSalary();
                System.out.println(totalSalaryOfEmployees);

                System.out.println("Count of employees with experience >= 5 years:");
                double experiencedEmployeesCount = analytics.countExperiencedEmployees(5);
                System.out.println(experiencedEmployeesCount);

                System.out.println("Employees with experience above 5 years:");
                analytics.findEmployeesWithExperienceAbove(5).forEach(System.out::println);

                System.out.println("Decending order of employees based on salary:");
                analytics.sortBySalaryDescending().forEach(System.out::println);

                System.out.println("Salary Statistics:");
                System.out.println(analytics.getSalaryStatistics());

                System.out.println("Employee Names:");
                analytics.getEmployeeNames().forEach(System.out::println);
        }
}
