package org.jsp.employeeapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.employeeapp.entity.EmployeeLeave;
import org.jsp.employeeapp.repository.EmployeeLeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeLeaveDao {
	
	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;
	
	public EmployeeLeave saveLeave(EmployeeLeave employeeLeave) {
		return employeeLeaveRepository.save(employeeLeave);
	}
	
	public Optional<EmployeeLeave> findLeaveById(int leaveId) {
		return employeeLeaveRepository.findById(leaveId);
	}

	public List<EmployeeLeave> findAllLeave(){
		return employeeLeaveRepository.findAll();
	}
}
