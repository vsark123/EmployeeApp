package org.jsp.employeeapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dao.ProjectDao;
import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.entity.Role;
import org.jsp.employeeapp.exception.InvalidAccountException;
import org.jsp.employeeapp.service.ProjectService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpln implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public ResponseStructure<Project> saveProject(Project project, Role role) {
		if (role == Role.MANAGER) {
			ResponseStructure<Project> responseStructure = new ResponseStructure<>();
			responseStructure.setData(projectDao.saveProject(project));
			return responseStructure;
		}
		throw new InvalidAccountException("Employee", "Role", "" + role, "Invalid Access");
	}

	@Override
	public ResponseStructure<String> assignProject(int employeeId, int projectId) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		Optional<Employee> optionalEmployee = employeeDao.findById(employeeId);
		Optional<Project> optionalProject = projectDao.findProjectById(projectId);
		if (optionalEmployee.isPresent() && optionalProject.isPresent()) {

			Employee employee = optionalEmployee.get();
			Project project = optionalProject.get();

			System.out.println(employee);
			System.out.println(project);

			if (employee.getProjects().size() == 0) {
				employee.setProjects(new ArrayList<>());
			}


			List<Project> projects = employee.getProjects();
			projects.add(project);
			
			employee.setProjects(projects);

			projectDao.saveProject(project);

			responseStructure.setData("Project assigned");
			return responseStructure;
		} else {
			responseStructure.setData("Invalid project or invalid employee");
			return responseStructure;
		}
	}
	
	

	@Override
	public ResponseStructure<String> deleteProject(int projectId) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		projectDao.deleteProject(projectDao.findProjectById(projectId).get());
		responseStructure.setData("Project deleted");
		return responseStructure;

	}

}
