package org.jsp.employeeapp.service;

import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.entity.Role;
import org.jsp.employeeapp.util.ResponseStructure;

public interface ProjectService {
	ResponseStructure<Project> saveProject(Project project, Role role);
	
	ResponseStructure<String> assignProject(int employeeId, int projectId);
	
	ResponseStructure<String> deleteProject(int projectId);

}
