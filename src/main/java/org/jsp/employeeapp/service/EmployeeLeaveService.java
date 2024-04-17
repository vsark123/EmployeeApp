package org.jsp.employeeapp.service;

import java.util.List;

import org.jsp.employeeapp.entity.EmployeeLeave;
import org.jsp.employeeapp.util.ResponseStructure;

public interface EmployeeLeaveService {
	
	ResponseStructure<EmployeeLeave> applyLeave(EmployeeLeave employeeLeave, int employeeId);
	
	ResponseStructure<List<EmployeeLeave>> findAllLeave();

	ResponseStructure<EmployeeLeave> approveLeave(int employeeId, int leaveId);
	
	

}
