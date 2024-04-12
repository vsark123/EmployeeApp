package org.jsp.employeeapp.dao;

import org.jsp.employeeapp.entity.Admin;
import org.jsp.employeeapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin findByUserNameOrEmail(String usernameOrEmail) {
		return adminRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
	}

	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

}
