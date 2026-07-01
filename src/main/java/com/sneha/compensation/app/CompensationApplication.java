package com.sneha.compensation.app;

import com.sneha.compensation.model.Employee;
import com.sneha.compensation.model.EmployeeRegistry;
import com.sneha.compensation.service.CompensationCalculator;

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
        double averageSalary = CompensationCalculator.calculateAverageBonus(bonus1, bonus2, bonus3, bonus4, bonus5);
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

    }
}
