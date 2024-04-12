package org.jsp.employeeapp.service;

import org.jsp.employeeapp.entity.Admin;
import org.jsp.employeeapp.entity.Login;
import org.jsp.employeeapp.util.ResponseStructure;

public interface LoginService {

	Login createEmployeeLoginAccount(Login login);
	
	ResponseStructure<Login> employeeLogin(String usernameOrEmail, String password);

	Login forgotPassword(String usernameOrEmail, String newPassword);

}
