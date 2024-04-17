package org.jsp.employeeapp.repository;

import java.util.List;

import org.jsp.employeeapp.entity.Employee;
import org.jsp.employeeapp.entity.EmployeeLeave;
import org.jsp.employeeapp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByEmail(String email);
	
	@Query("select e.projects from Employee e where e.id=?1")
	List<Project> findProjectByEmployeeId(int employeeId);
	
	@Query("select e.employeeLeaves from Employee e where e.id=?1 and e.role=EMPLOYEE")
	List<EmployeeLeave> findEmployeeLeaveByEmployeeId(int employeeId);

}
