package org.jsp.employeeapp.dao;

import org.jsp.employeeapp.entity.Account;
import org.jsp.employeeapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

}
