package com.sneha.compensation.recordmodel;

public record CompensationReport(
		int employeeId,
		String employeeName,
		double baseSalary,
		double bonus,
		double totalCompensation) {

	public CompensationReport {

		if (employeeId <= 0) {
			throw new IllegalArgumentException(
					"Invalid employee id");
		}

		if (employeeName == null
				|| employeeName.isBlank()) {

			throw new IllegalArgumentException(
					"Employee name required");
		}
	}
}