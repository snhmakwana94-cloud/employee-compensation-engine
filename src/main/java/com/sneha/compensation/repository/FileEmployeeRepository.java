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

    public FileEmployeeRepository() {

        loadEmployeesFromFile();

    }

    private void loadEmployeesFromFile() {
        if (!Files.exists(FILE_PATH)) {
            return;
        }

        try {

            List<String> lines = Files.readAllLines(FILE_PATH);

            for (String line : lines) {
                String[] data = line.split(",");
                Employee employee = new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]),
                        Integer.parseInt(data[4]));
                employees.add(employee);
            }

        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }

    private void rewriteFile() {

        try {

            List<String> lines = new ArrayList<>();

            for (Employee employee : employees) {

                lines.add(String.format(
                        "%d,%s,%s,%.2f,%d",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getDepartment(),
                        employee.getBaseSalary(),
                        employee.getExperienceYears()));
            }

            Files.write(
                    FILE_PATH,
                    lines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }

    @Override
    public void save(Employee employee) {

        employees.add(employee);
        rewriteFile();
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
    public boolean deleteById(int employeeId) {

        boolean removed = employees.removeIf(
                employee -> employee.getEmployeeId() == employeeId);

        if (removed) {
            rewriteFile();
        }

        return removed;
    }
}