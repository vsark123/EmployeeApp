package org.jsp.employeeapp.controller;

import org.jsp.employeeapp.entity.Login;
import org.jsp.employeeapp.service.LoginService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("employeeLogin")
	public ResponseEntity<ResponseStructure<Login>> employeeLogin(@RequestHeader String usernameOrEmail, @RequestHeader String password) {
		return new ResponseEntity<ResponseStructure<Login>>(loginService.employeeLogin(usernameOrEmail, password), HttpStatus.OK);
	}

	@PutMapping("forgotPassword")
	public ResponseEntity<Login> forgorPassword(@RequestBody Login login) {
		return new ResponseEntity<Login>(loginService.forgotPassword(login.getUsername(), login.getPassword()), HttpStatus.CREATED);
	}

}
