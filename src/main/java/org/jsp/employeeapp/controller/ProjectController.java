package org.jsp.employeeapp.controller;

import org.jsp.employeeapp.entity.Project;
import org.jsp.employeeapp.entity.Role;
import org.jsp.employeeapp.service.ProjectService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("saveProject")
	public ResponseEntity<ResponseStructure<Project>> saveProject(@RequestBody Project project, @RequestHeader Role role){
		return new ResponseEntity<ResponseStructure<Project>>(projectService.saveProject(project, role), HttpStatus.CREATED);
	}

	@GetMapping("assignProject")
	public ResponseEntity<ResponseStructure<String>> assignProject(@RequestHeader int employeeId, @RequestHeader int projectId ){
		return new ResponseEntity<ResponseStructure<String>>(projectService.assignProject(employeeId, projectId), HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteProject")
	public ResponseEntity<ResponseStructure<String>> deleteProject(@RequestHeader int projectId ){
		return new ResponseEntity<ResponseStructure<String>>(projectService.deleteProject(projectId), HttpStatus.CREATED);
	}
	
	

}
