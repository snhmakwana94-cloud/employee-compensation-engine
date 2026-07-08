package com.sneha.compensation.analytics;

import com.sneha.compensation.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.DoubleSummaryStatistics;

public class CompensationAnalytics {

    // private final List<Employee> employees;

    // public CompensationAnalytics(
    // List<Employee> employees) {

    // this.employees = employees;
    // }

    // public List<Employee> findEmployeesWithSalaryAbove(double salary) {

    // return employees.stream()
    // .filter(employee -> employee.getBaseSalary() > salary)
    // .toList();
    // }

    // public List<Employee> findEmployeesByDepartment(String department) {
    // return employees.stream()
    // .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
    // .toList();
    // }

    // public Optional<Employee> findHighestPaidEmployee() {
    // return
    // employees.stream().max(Comparator.comparingDouble(Employee::getBaseSalary));
    // }

    // public Optional<Employee> findLowestPaidEmployee() {
    // return
    // employees.stream().min(Comparator.comparingDouble(Employee::getBaseSalary));
    // }

    // public double calculateAverageSalary() {
    // return employees.stream()
    // .mapToDouble(Employee::getBaseSalary)
    // .average()
    // .orElse(0.0);
    // }

    // public double calculateTotalSalary() {
    // return employees.stream()
    // .mapToDouble(Employee::getBaseSalary)
    // .sum();
    // }

    // public double countExperiencedEmployees(int yearsOfExperience) {
    // return employees.stream()
    // .filter(employee -> employee.getExperienceYears() >= yearsOfExperience)
    // .count();
    // }

    // public List<Employee> findEmployeesWithExperienceAbove(int years) {
    // return employees.stream()
    // .filter(employee -> employee.getExperienceYears() > years)
    // .toList();
    // }

    // public List<Employee> sortBySalaryDescending() {
    // return employees.stream()
    // .sorted(Comparator.comparingDouble(Employee::getBaseSalary).reversed())
    // .toList();
    // }

    // public DoubleSummaryStatistics getSalaryStatistics() {
    // return employees.stream()
    // .mapToDouble(
    // Employee::getBaseSalary)
    // .summaryStatistics();
    // }

    // public List<String> getEmployeeNames() {

    // return employees.stream()
    // .map(Employee::getName)
    // .toList();

    // }
    public long totalEmployees(List<Employee> employees) {

        return employees.size();
    }

    public double totalPayroll(List<Employee> employees) {

        return employees.stream()
                .mapToDouble(Employee::getBaseSalary)
                .sum();
    }

    public double averageSalary(List<Employee> employees) {

        return employees.stream()
                .mapToDouble(Employee::getBaseSalary)
                .average()
                .orElse(0.0);
    }

    public Optional<Employee> highestPaidEmployee(List<Employee> employees) {

        return employees.stream()
                .max(Comparator.comparing(Employee::getBaseSalary));
    }

    public Optional<Employee> lowestPaidEmployee(List<Employee> employees) {

        return employees.stream()
                .min(Comparator.comparing(Employee::getBaseSalary));
    }
}