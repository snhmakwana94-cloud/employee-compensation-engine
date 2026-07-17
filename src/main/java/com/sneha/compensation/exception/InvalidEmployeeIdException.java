package com.sneha.compensation.exception;

public class InvalidEmployeeIdException
        extends EmployeeValidationException {

    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}