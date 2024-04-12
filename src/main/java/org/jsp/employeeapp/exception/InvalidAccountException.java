package org.jsp.employeeapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidAccountException extends RuntimeException {
	
	private String entity;
	private String attribute;
	private String value;
	private String message;

}
