package com.sneha.compensation.exception;

public class InvalidSalaryException
        extends EmployeeValidationException {

    public InvalidSalaryException(String message) {
        super(message);
    }
}