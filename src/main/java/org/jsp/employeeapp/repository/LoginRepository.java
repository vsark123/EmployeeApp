package org.jsp.employeeapp.repository;

import org.jsp.employeeapp.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query("select l from Login l where (l.username=?1 or l.email=?2) and l.password=?3")
	public Login loginValidate(String username, String email, String password);

	@Query("select l from Login l where l.username=?1 or l.email=?2")
	public Login findByUserNameOrEmail(String username, String email);

}
