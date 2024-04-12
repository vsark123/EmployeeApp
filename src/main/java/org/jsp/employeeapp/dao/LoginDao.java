package org.jsp.employeeapp.dao;

import org.jsp.employeeapp.entity.Login;
import org.jsp.employeeapp.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public Login saveEmployeeLoginAccount(Login login) {
		return loginRepository.save(login);
	}
	
	public Login loginValidate(String usernameOrEmail, String password) {
		return loginRepository.loginValidate(usernameOrEmail, usernameOrEmail, password);
	}

	public Login findByUserNameOrEmail(String usernameOrEmail) {
		return loginRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
	}

	

}
