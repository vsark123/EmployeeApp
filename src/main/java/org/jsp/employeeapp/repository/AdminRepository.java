package org.jsp.employeeapp.repository;

import org.jsp.employeeapp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("select a from Admin a where a.username=?1 or a.email=?2")
	public Admin findByUserNameOrEmail(String username, String email);
}
