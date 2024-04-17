package org.jsp.employeeapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dao.EmployeeLeaveDao;
import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.EmployeeLeave;
import org.jsp.employeeapp.entity.Role;
import org.jsp.employeeapp.exception.InvalidAccountException;
import org.jsp.employeeapp.service.EmployeeLeaveService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeLeaveServiceImpln implements EmployeeLeaveService {

	@Autowired
	private EmployeeLeaveDao employeeLeaveDao;

	@Autowired
	private EmployeeDao employeeDao;


	@Override
	public ResponseStructure<EmployeeLeave> applyLeave(EmployeeLeave employeeLeave, int employeeId) {
		Optional<Employee> optional = employeeDao.findById(employeeId);
		Employee employee = optional.get();
		
		if (optional.isPresent()) {
			if (employee.getEmployeeLeaves().size() == 0) {
				employee.setEmployeeLeaves(new ArrayList<>());
				ResponseStructure<EmployeeLeave> responseStructure = new ResponseStructure<>();
				employeeLeave.setRemainingLeave(
						employeeLeave.getTotalLeave() - employeeLeave.getDaysRequested());
				employee.getEmployeeLeaves().add(employeeLeave);
				employee.setEmployeeLeaves(employee.getEmployeeLeaves());
				responseStructure.setData(employeeLeaveDao.saveLeave(employeeLeave));
				return responseStructure;
			}
			List<EmployeeLeave> employeeLeaves = employeeDao.findEmployeeLeaveByEmployeeId(employeeId);
			if (employeeLeaves.get(employeeLeaves.size()-1).getRemainingLeave() > 0) {
				
				ResponseStructure<EmployeeLeave> responseStructure = new ResponseStructure<>();
				employeeLeave.setTotalLeave(employeeLeaves.get(employeeLeaves.size()-1).getRemainingLeave());
				employeeLeave.setRemainingLeave(
						employeeLeave.getTotalLeave() - employeeLeave.getDaysRequested());
				employee.getEmployeeLeaves().add(employeeLeave);
				employee.setEmployeeLeaves(employee.getEmployeeLeaves());
				responseStructure.setData(employeeLeaveDao.saveLeave(employeeLeave));
				return responseStructure;
			}else {
				throw new InvalidAccountException("EmployeeLeave", "Leave", "Employee id: " + employeeId, "There is no paid leave remaining");

			}
		}
		throw new InvalidAccountException("Employee", "Account", "" + employeeId, "Invalid Employee");
	}

	@Override
	public ResponseStructure<List<EmployeeLeave>> findAllLeave() {
		ResponseStructure<List<EmployeeLeave>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(employeeLeaveDao.findAllLeave());
		return responseStructure;
	}

	@Override
	public ResponseStructure<EmployeeLeave> approveLeave(int employeeId, int leaveId) {
		Optional<Employee> optionalEmployee = employeeDao.findById(employeeId);
		Optional<EmployeeLeave> optionalEmployeeLeave =  employeeLeaveDao.findLeaveById(leaveId);

		if(optionalEmployee.isPresent() && optionalEmployee.get().getRole()==Role.MANAGER ) {
			ResponseStructure<EmployeeLeave> responseStructure = new ResponseStructure<>();
			optionalEmployeeLeave.get().setStatus(true);
			responseStructure.setData(employeeLeaveDao.saveLeave(optionalEmployeeLeave.get()));
			return responseStructure;
		}
		throw new InvalidAccountException("Employee", "Role", "Role is not manager with employee id: " + employeeId, "Invalid Manager");
	}

}
