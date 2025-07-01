package com.yedam.app.depart.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartVO {
	// employee_id => employeeId => setEmployeeId
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}
