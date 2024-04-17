package org.jsp.employeeapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.EmployeeLeave;
import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	public Optional<Employee> findById(int employeeId) {
		return employeeRepository.findById(employeeId);
	}

	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);;
	}

	public List<Project> findProjectByEmployeeId(int employeeId) {
		return employeeRepository.findProjectByEmployeeId(employeeId);
	}
	
	public List<EmployeeLeave> findEmployeeLeaveByEmployeeId(int employeeId) {
		return employeeRepository.findEmployeeLeaveByEmployeeId(employeeId);
	}

}
