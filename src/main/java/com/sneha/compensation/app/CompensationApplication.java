package com.sneha.compensation.app;

import com.sneha.compensation.model.Employee;
import com.sneha.compensation.model.EmployeeRegistry;

public class CompensationApplication {
    public static void main(String[] args) {

        EmployeeRegistry registory = new EmployeeRegistry("Hr Department");

        Employee emp1 = new Employee(1001, "Sneha", "IT", 50000.0, 5);
        Employee emp2 = new Employee(1002, "John", "Finance", 60000.0, 7);
        Employee emp3 = new Employee(1003, "Alice", "HR", 55000.0, 4);

        EmployeeRegistry.registerEmployeeIntoList(emp1);
        EmployeeRegistry.registerEmployeeIntoList(emp2);
        EmployeeRegistry.registerEmployeeIntoList(emp3);

        System.out.println("Registry Name: " + registory.getRegistryName());
        System.out.println("Total Employees: " + EmployeeRegistry.getTotalEmployees());
        System.out.println("Employee List: ");

        EmployeeRegistry registory1 = new EmployeeRegistry("Sales Department");
        System.out.println("Registry Name: " + registory1.getRegistryName());

        for (Employee emp : EmployeeRegistry.getAllEmployees()) {
            System.out.println(emp);
        }

    }
}
