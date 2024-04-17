package org.jsp.employeeapp.dao;

import java.util.Optional;

import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	public Optional<Project> findProjectById(int projectId) {
		return projectRepository.findById(projectId);
	}

	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}
	
	
}
