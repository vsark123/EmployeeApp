package org.jsp.employeeapp.serviceimpl;

import org.jsp.employeeapp.dao.AdminDao;
import org.jsp.employeeapp.dao.LoginDao;
import org.jsp.employeeapp.entity.Admin;
import org.jsp.employeeapp.entity.Login;
import org.jsp.employeeapp.exception.InvalidAccountException;
import org.jsp.employeeapp.service.AdminService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private LoginDao loginDao;

	@Override
	public Admin createAdmin(Admin admin) {
		admin.setPassword(encoder.encode(admin.getPassword()));
		return adminDao.createAdmin(admin);
	}

	@Override
	public ResponseStructure<Admin> adminLogin(String usernameOrEmail, String password) {
		Admin admin = adminDao.findByUserNameOrEmail(usernameOrEmail);
		if (admin != null && encoder.matches(password, admin.getPassword())) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			int otp = (int) (Math.random() * 10000);
			mailMessage.setTo(admin.getEmail());
			mailMessage.setFrom("vsark8573@gmail.com");
			mailMessage.setSubject("Login OTP");
			mailMessage.setText("Your login OTP is " + otp);
			Thread sendMailThread = new Thread(() -> {
				javaMailSender.send(mailMessage);
			});
			sendMailThread.start();
			
			ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
			responseStructure.setData(admin);
			responseStructure.setStatusCode(202);
			responseStructure.setMessage(""+otp);;
			System.out.println(otp);
			return responseStructure; 
		}
		throw new InvalidAccountException("Admin", "Username or Email", usernameOrEmail,
				"Account is not created with this id " + usernameOrEmail);
	}

	public Login createEmployeeAccount(Login login) {
		login.setPassword(encoder.encode(login.getPassword()));
		return loginDao.saveEmployeeLoginAccount(login);
	}

}
