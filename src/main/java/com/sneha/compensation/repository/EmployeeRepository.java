package com.sneha.compensation.repository;

import com.sneha.compensation.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    void save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(int employeeId);

    boolean deleteById(int employeeId);
}