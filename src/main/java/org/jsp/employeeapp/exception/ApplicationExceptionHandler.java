package org.jsp.employeeapp.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity handleInvalidAccountException(InvalidAccountException exception) {
		return new ResponseEntity<>(exception, HttpStatus.NOT_ACCEPTABLE);

	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity handleConstraintViolationException(ConstraintViolationException exception) {
		return new ResponseEntity<>(exception, HttpStatus.NOT_ACCEPTABLE);
	} 
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
		return new ResponseEntity<>(exception, HttpStatus.NOT_ACCEPTABLE);
	} 


}
