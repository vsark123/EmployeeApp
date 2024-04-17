package org.jsp.employeeapp.controller;

import java.util.List;

import org.jsp.employeeapp.entity.EmployeeLeave;
import org.jsp.employeeapp.service.EmployeeLeaveService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeLeaveController {
	
	@Autowired
	private EmployeeLeaveService employeeLeaveService;
	
	@PostMapping("applyLeave")
	public ResponseEntity<ResponseStructure<EmployeeLeave>> applyLeave(@RequestBody EmployeeLeave employeeLeave, @RequestHeader int employeeId) {
		return new ResponseEntity<ResponseStructure<EmployeeLeave>>(employeeLeaveService.applyLeave(employeeLeave, employeeId), HttpStatus.OK);
	}
	
	@GetMapping("findAllLeave")
	public ResponseEntity<ResponseStructure<List<EmployeeLeave>>> findAllLeave(){
		return new ResponseEntity<ResponseStructure<List<EmployeeLeave>>>(employeeLeaveService.findAllLeave(), HttpStatus.OK);
	}
	
	@PostMapping("approveLeave")
	public ResponseEntity<ResponseStructure<EmployeeLeave>> approveLeave(@RequestHeader int employeeId, @RequestHeader int leaveId){
		return new ResponseEntity<ResponseStructure<EmployeeLeave>>(employeeLeaveService.approveLeave(employeeId, leaveId), HttpStatus.OK);
		
	}

}
