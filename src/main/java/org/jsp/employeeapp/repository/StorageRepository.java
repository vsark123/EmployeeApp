package org.jsp.employeeapp.repository;

import org.jsp.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Employee, Integer>{

}
