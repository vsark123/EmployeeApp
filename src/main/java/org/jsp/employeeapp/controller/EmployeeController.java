package org.jsp.employeeapp.controller;

import java.util.List;

import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.service.EmployeeService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("getProfile")
	public ResponseEntity<ResponseStructure<Employee>> getProfile(@RequestParam String email) {
		return new ResponseEntity<ResponseStructure<Employee>>(employeeService.getProfile(email), HttpStatus.CREATED);
	}

	@GetMapping("editProfile")
	public ResponseEntity<ResponseStructure<Employee>> editProfile(@RequestParam String email) {
		return new ResponseEntity<ResponseStructure<Employee>>(employeeService.editProfile(email), HttpStatus.CREATED);
	}

	@PutMapping("updateProfile")
	public ResponseEntity<ResponseStructure<Employee>> updateProfile(@RequestBody Employee employee) {
		return new ResponseEntity<ResponseStructure<Employee>>(employeeService.updateEmployee(employee),
				HttpStatus.CREATED);
	}

	@DeleteMapping("deleteProfile")
	public ResponseEntity<ResponseStructure<String>> deleteProfile(@RequestHeader int employeeId) {
		return new ResponseEntity<ResponseStructure<String>>(employeeService.deleteEmployee(employeeId),
				HttpStatus.CREATED);
	}
	
	@GetMapping("findProjectByEmployeeId")
	public ResponseEntity<ResponseStructure<List<Project>>> findProjectByEmployeeId(@RequestHeader int employeeId) {
		return new ResponseEntity<ResponseStructure<List<Project>>>(employeeService.findProjectByEmployeeId(employeeId), HttpStatus.CREATED);
	}

}
