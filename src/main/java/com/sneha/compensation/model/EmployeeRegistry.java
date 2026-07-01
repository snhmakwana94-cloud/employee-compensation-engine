package com.sneha.compensation.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistry {

    private static int totalEmployees = 0;

    // STATIC collection shared across all instances
    private static List<Employee> employeeList = new ArrayList<>();

    // INSTANCE variable (belongs to object)
    private String registryName;

    // STATIC BLOCK (runs once when class loads)
    static {
        System.out.println("EmployeeRegistry class loaded into memory");
    }

    // INSTANCE BLOCK (runs before constructor)
    {
        System.out.println("Instance initialization block executed");
    }

    // Constructor

    public EmployeeRegistry(String registryName) {
        this.registryName = registryName;
        System.out.println("Registry Name executed from constructor: " + registryName);
    }

    // STATIC METHOD
    public static void registerEmployeeIntoList(Employee employee) {
        employeeList.add(employee);
        totalEmployees++;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static List<Employee> getAllEmployees() {
        return employeeList;
    }

    // INSTANCE METHOD
    public String getRegistryName() {
        return registryName;
    }
}