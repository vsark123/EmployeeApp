package org.jsp.employeeapp.service;

import java.util.List;

import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	ResponseStructure<Employee> editProfile(String email);
	
	ResponseStructure<Employee> getProfile(String email);
	
	ResponseStructure<Employee> updateEmployee(Employee updatedEmployee);
	
	public String uploadImage(MultipartFile file);

	ResponseStructure<String> deleteEmployee(int employeeId);
	
	ResponseStructure<List<Project>> findProjectByEmployeeId(int employeeId);
	

}
