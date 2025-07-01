package com.yedam.app.emp.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {
	// employee_id => employeeId => setEmployeeId
	private Integer employeeId;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	private double salary;
}
