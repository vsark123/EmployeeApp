package org.jsp.employeeapp.serviceimpl;

import java.util.List;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.exception.InvalidAccountException;
import org.jsp.employeeapp.service.EmployeeService;
import org.jsp.employeeapp.util.ImageUtils;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeServiceImpln implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public ResponseStructure<Employee> editProfile(String email) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employeeDao.findByEmail(email));
		responseStructure.setMessage("Edit Profile");
		return responseStructure;
	}

	@Override
	public ResponseStructure<Employee> updateEmployee(Employee updatedEmployee) {
		Employee employee = employeeDao.findByEmail(updatedEmployee.getEmail());
		if (employee != null) {
			employee.setName(updatedEmployee.getName());
			employee.setGender(updatedEmployee.getGender());
			employee.setDob(updatedEmployee.getDob());
			employee.setPhone(updatedEmployee.getPhone());
			ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
			responseStructure.setData(employeeDao.saveEmployee(employee));
			responseStructure.setMessage("Profile Updated");
			return responseStructure;
		}
		throw new InvalidAccountException("Employee","Email",""+updatedEmployee.getEmail(),"Invalid Employee");
	}

	@Override
	public ResponseStructure<Employee> getProfile(String email) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employeeDao.saveEmployee(employeeDao.findByEmail(email)));
		responseStructure.setMessage("Profile Updated");
		return responseStructure;
	}
	
	@Override
	public String uploadImage(MultipartFile file) {
//		Employee imageData = employeeDao.save(Employee.builder()
//				.name(file.getOriginalFilename())
//				.type(file.getContentType())
//				.imageData(ImageUtils.compressImage(file.getBytes())).build());
//		if (imageData != null) {
//			return "file uploaded successfully : " + file.getOriginalFilename();
//		}
		return null;
	}

	@Override
	public ResponseStructure<String> deleteEmployee(int employeeId) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		employeeDao.deleteEmployee(employeeDao.findById(employeeId).get());
		responseStructure.setData("Employee deleted");
		return responseStructure;
	}

	@Override
	public ResponseStructure<List<Project>> findProjectByEmployeeId(int employeeId) {
		ResponseStructure<List<Project>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employeeDao.findProjectByEmployeeId(employeeId));
		return responseStructure;
	}

}
