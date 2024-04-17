package org.jsp.employeeapp.service;

import org.jsp.employeeapp.entity.Account;
import org.jsp.employeeapp.util.ResponseStructure;

public interface AccountService {
	
	ResponseStructure<Account> saveAccount(Account account);

}
