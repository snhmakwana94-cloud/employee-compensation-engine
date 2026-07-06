package com.sneha.compensation.repository;

import com.sneha.compensation.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileEmployeeRepository
        implements EmployeeRepository {

    private static final Path FILE_PATH = Path.of(
            "data",
            "employees.txt");

    private final List<Employee> employees = new ArrayList<>();

    private void saveToFile(Employee employee) {

        try {

            String line = employee.getEmployeeId()
                    + ","
                    + employee.getName()
                    + System.lineSeparator();

            Files.writeString(
                    FILE_PATH,
                    line,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }

    @Override
    public void save(Employee employee) {

        employees.add(employee);
        saveToFile(employee);
    }

    @Override
    public List<Employee> findAll() {

        return new ArrayList<>(employees);
    }

    @Override
    public Optional<Employee> findById(
            int employeeId) {

        for (Employee employee : employees) {

            if (employee.getEmployeeId() == employeeId) {

                return Optional.of(employee);
            }
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(
            int employeeId) {

        return employees.removeIf(
                employee -> employee.getEmployeeId() == employeeId);
    }
}