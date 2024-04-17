package org.jsp.employeeapp.repository;

import org.jsp.employeeapp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
//	Project findProjectsByEmployeeId(int employeeId);
	
}
