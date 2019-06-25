package com.neuedu.web02.service;

import java.util.ArrayList;

import com.neuedu.web02.entity.Bank;

public interface BankCenterService {
	Bank insertBank(Bank band);
	
	ArrayList<Bank> getAllBank(Integer userId);
	
	int bankIntoRecycle(Integer bankId);
	
	int editBank(Bank bank);
	
	Bank getBanKById(Integer id);
	
	ArrayList<Bank> getRecycleList(Integer userId);
	
	int insertIntoBankTeacherMapping(Integer userId, Integer bankId);
	
	int destoryBankByBankId(Integer bankId);
	
	int recoverBankByBankId(Integer bankId);
	
	int clearRecycleByUserId(Integer userId);
	
	int recoverBankAllByUserId(Integer userId);
	
	Integer getQuestionCountByBankId(Integer bankId);
	
}
