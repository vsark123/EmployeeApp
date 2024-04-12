package org.jsp.employeeapp.serviceimpl;

import org.jsp.employeeapp.dao.LoginDao;
import org.jsp.employeeapp.entity.Admin;
import org.jsp.employeeapp.entity.Login;
import org.jsp.employeeapp.exception.InvalidAccountException;
import org.jsp.employeeapp.service.LoginService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpln implements LoginService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private LoginDao loginDao;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public Login createEmployeeLoginAccount(Login login) {
		login.setPassword(encoder.encode(login.getPassword()));
		return loginDao.saveEmployeeLoginAccount(login);
	}

	@Override
	public ResponseStructure<Login> employeeLogin(String usernameOrEmail, String password) {
		Login login = loginDao.findByUserNameOrEmail(usernameOrEmail);
		System.out.println(login);
		if (login != null ) {
			if(encoder.matches(password, login.getPassword())) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			int otp = (int) (Math.random() * 10000);
			System.out.println(otp);
			mailMessage.setTo(login.getEmail());
			mailMessage.setFrom("vsark8573@gmail.com");
			mailMessage.setSubject("Login OTP");
			mailMessage.setText("Your login OTP is " + otp);
			//javaMailSender.send(mailMessage);

			Thread sendMailThread = new Thread(() -> {
				javaMailSender.send(mailMessage);
			});
			ResponseStructure<Login> responseStructure = new ResponseStructure<>();
			responseStructure.setData(login);
			responseStructure.setStatusCode(202);
			responseStructure.setMessage(""+otp);;
			System.out.println(otp);
			return responseStructure;
			}
			throw new InvalidAccountException("Employee", "Password", password,
					"Invalid password" + password);
		}
		throw new InvalidAccountException("Employee", "Username or Email", usernameOrEmail,
				"Account is not created with this id " + usernameOrEmail);
	}

	@Override
	public Login forgotPassword(String usernameOrEmail, String newPassword) {
		Login login = loginDao.findByUserNameOrEmail(usernameOrEmail);
		System.out.println(login);
		if (login != null) {
			login.setPassword(encoder.encode(newPassword));
			return loginDao.saveEmployeeLoginAccount(login);
		}
		throw new InvalidAccountException("Employee", "Username or Email", usernameOrEmail,
				"Account is not created with this id " + usernameOrEmail);
	}

}
