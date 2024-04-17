package org.jsp.employeeapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmployeeLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	private String leaveType;
	private int daysRequested;
	private int totalLeave=100;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate dateOfApplication;
	private boolean status;
	private LocalDate dateOfApproval;
	private int remainingLeave;

}
