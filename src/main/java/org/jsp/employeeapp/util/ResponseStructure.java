package org.jsp.employeeapp.util;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
	private T data;
	private int statusCode;
	private String message;
}
