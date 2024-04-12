package org.jsp.employeeapp.service;

import org.jsp.employeeapp.entity.Admin;
import org.jsp.employeeapp.entity.Login;
import org.jsp.employeeapp.util.ResponseStructure;

public interface AdminService {
	
	Admin createAdmin(Admin admin);
	
	ResponseStructure<Admin> adminLogin(String usernameOrEmail, String password);
	
	Login createEmployeeAccount(Login login);
}
