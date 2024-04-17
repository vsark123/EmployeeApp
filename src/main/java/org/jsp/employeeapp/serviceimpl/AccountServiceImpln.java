package org.jsp.employeeapp.serviceimpl;

import org.jsp.employeeapp.dao.AccountDao;
import org.jsp.employeeapp.entity.Account;
import org.jsp.employeeapp.service.AccountService;
import org.jsp.employeeapp.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpln implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public ResponseStructure<Account> saveAccount(Account account) {
		ResponseStructure<Account> responseStructure = new ResponseStructure<>();
		responseStructure.setData(accountDao.saveAccount(account));
		return responseStructure;
	}

}
