package org.jsp.employeeapp.repository;

import org.jsp.employeeapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
}
