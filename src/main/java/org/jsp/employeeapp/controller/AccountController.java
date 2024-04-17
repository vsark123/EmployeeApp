package org.jsp.employeeapp.controller;

import org.jsp.employeeapp.entity.Account;
import org.jsp.employeeapp.service.AccountService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("saveAcccount")
	public ResponseEntity<ResponseStructure<Account>> saveAccount(@RequestBody Account account) {
		return new ResponseEntity<ResponseStructure<Account>>(accountService.saveAccount(account), HttpStatus.OK);
	}

}
