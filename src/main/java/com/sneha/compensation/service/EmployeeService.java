package com.sneha.compensation.service;

import java.util.List;
import java.util.Optional;

import com.sneha.compensation.analytics.CompensationAnalytics;
import com.sneha.compensation.dto.AnalyticsReport;
import com.sneha.compensation.dto.PayrollSummary;
import com.sneha.compensation.model.Employee;
import com.sneha.compensation.repository.EmployeeRepository;

public class EmployeeService {

    private final EmployeeRepository repository;
    private final CompensationAnalytics analytics = new CompensationAnalytics();

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void registerEmployee(Employee employee) {

        repository.save(employee);

    }

    public boolean employeeExists(int employeeId) {

        return repository.findById(employeeId)
                .isPresent();
    }

    public List<Employee> getAllEmployees() {

        return repository.findAll();

    }

    public Optional<Employee> findEmployeeById(int employeeId) {

        return repository.findById(employeeId);

    }

    public boolean deleteEmployee(int employeeId) {

        return repository.deleteById(employeeId);

    }

    public long getTotalEmployees() {

        return analytics.totalEmployees(
                repository.findAll());
    }

    public double getTotalPayroll() {

        return analytics.totalPayroll(
                repository.findAll());
    }

    public double getAverageSalary() {

        return analytics.averageSalary(
                repository.findAll());
    }

    public Optional<Employee> getHighestPaidEmployee() {

        return analytics.highestPaidEmployee(
                repository.findAll());
    }

    public Optional<Employee> getLowestPaidEmployee() {

        return analytics.lowestPaidEmployee(
                repository.findAll());
    }

    public AnalyticsReport getAnalyticsReport() {

        var employees = repository.findAll();

        return new AnalyticsReport(

                analytics.totalEmployees(employees),

                analytics.totalPayroll(employees),

                analytics.averageSalary(employees),

                analytics.highestPaidEmployee(employees)
                        .orElse(null),

                analytics.lowestPaidEmployee(employees)
                        .orElse(null));
    }

    public List<PayrollSummary> getPayrollSummary() {

        return repository.findAll()

                .stream()

                .map(employee ->

                new PayrollSummary(

                        employee.getEmployeeId(),

                        employee.getName(),

                        employee.getBaseSalary(),

                        employee.getBaseSalary() / 12))

                .toList();
    }

}