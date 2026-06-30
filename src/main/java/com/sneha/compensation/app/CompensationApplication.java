package com.sneha.compensation.app;

import com.sneha.compensation.model.Employee;

public class CompensationApplication {
    public static void main(String[] args) {

        Employee employee1 = new Employee(
                101,
                "Sneha Makwana",
                "Engineering",
                120000,
                10);

        Employee badEmployee = new Employee(
                104,
                "",
                "Engineering",
                -5000,
                -1);

        System.out.println(employee1);
        System.out.println(badEmployee);
    }
}
