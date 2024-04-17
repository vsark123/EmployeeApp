package org.jsp.employeeapp.controller;

import org.jsp.employeeapp.entity.Admin;
import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.Login;
import org.jsp.employeeapp.entity.Role;
import org.jsp.employeeapp.repository.AdminRepository;
import org.jsp.employeeapp.service.AdminService;
import org.jsp.employeeapp.service.EmployeeService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// Logger logger =

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("createAdminAccount")
	public Admin createAdmin(@RequestBody Admin admin) {
		adminService.createAdmin(admin);

		return admin;
	}

	@RequestMapping("/validate")
	public String validate(Admin admin) {
		return "createEmployeeAccount.jsp";
	}

	@PostMapping("adminLogin")
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.adminLogin(admin.getUsername(), admin.getPassword()),
				HttpStatus.ACCEPTED);
	}

	@PostMapping("createEmployeeAccount")
	public ResponseEntity<Login> createEmployeeAccount(@RequestBody Login login, @RequestParam Role role) {
		Employee employee = new Employee();
		employee.setEmail(login.getEmail());
		employee.setRole(role);
		login.setEmployee(employee);
		employeeService.saveEmployee(employee);
		return new ResponseEntity<Login>(adminService.createEmployeeAccount(login), HttpStatus.CREATED);
	}

	@DeleteMapping("deleteEmployeeAccount")
	public ResponseEntity<Login> deleteEmployeeAccount(@RequestBody Login login) {
		Employee employee = new Employee();
		employee.setEmail(login.getEmail());
		employee.setRole(Role.EMPLOYEE);
		login.setEmployee(employee);
		employeeService.saveEmployee(employee);
		return new ResponseEntity<Login>(adminService.createEmployeeAccount(login), HttpStatus.CREATED);
	}

}
