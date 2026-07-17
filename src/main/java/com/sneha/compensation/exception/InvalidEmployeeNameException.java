package com.sneha.compensation.exception;

public class InvalidEmployeeNameException
        extends EmployeeValidationException {

    public InvalidEmployeeNameException(
            String message) {

        super(message);
    }
}