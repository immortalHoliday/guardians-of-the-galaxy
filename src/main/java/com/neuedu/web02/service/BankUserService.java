package com.neuedu.web02.service;

import com.neuedu.web02.entity.User;

public interface BankUserService {

	User findUserByMail(String userMail);
	
	User findUserById(Integer userId);
	
	User findUserByBankId(Integer bankId);
}
