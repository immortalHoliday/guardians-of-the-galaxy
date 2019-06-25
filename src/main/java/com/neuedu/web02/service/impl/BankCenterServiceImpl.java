package com.neuedu.web02.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.web02.dao.BankMapper;
import com.neuedu.web02.dao.BankTeacherMappingMapper;
import com.neuedu.web02.dao.QuestionMapper;
import com.neuedu.web02.dao.UserMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankExample;
import com.neuedu.web02.entity.BankTeacherMapping;
import com.neuedu.web02.entity.BankTeacherMappingExample;
import com.neuedu.web02.entity.Question;
import com.neuedu.web02.entity.QuestionExample;
import com.neuedu.web02.service.BankCenterService;

@Service
public class BankCenterServiceImpl implements BankCenterService {
	
	@Autowired
	BankMapper bankMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	BankTeacherMappingMapper bankTeacherMappingMapper;
	@Autowired
	QuestionMapper questionMapper;
	
	@Override
	public Bank insertBank(Bank bank) {
		int value = bankMapper.insertSelective(bank);
		Bank newBank = bankMapper.selectByPrimaryKey(bank.getId());
		return newBank;
	}
	
	@Override
	public ArrayList<Bank> getAllBank(Integer userId){
		ArrayList<Bank> list = (ArrayList)bankMapper.selectUseableBankByCreaterId(userId);
		return list;
	}

	@Override
	public int bankIntoRecycle(Integer bankId) {
		Bank record = new Bank();
		BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bankId);
		record.setDeleteflag(1);
		int value = bankMapper.updateByExampleSelective(record, bankExample);
		return value;
	}

	@Override
	public int editBank(Bank bank) {
		BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bank.getId());
		int value = bankMapper.updateByExampleSelective(bank, bankExample);
		return value;
	}

	@Override
	public Bank getBanKById(Integer id) {
		Bank bank = bankMapper.selectByPrimaryKey(id);
		return bank;
	}

	@Override
	public ArrayList<Bank> getRecycleList(Integer userId) {
		ArrayList<Bank> list = (ArrayList)bankMapper.selectBankInRecycleByCreaterId(userId);
		return list;
	}

	@Override
	public int insertIntoBankTeacherMapping(Integer userId, Integer bankId) {
		int value = bankTeacherMappingMapper.insertSelective(new BankTeacherMapping(bankId, userId));
		return value;
	}

	@Override
	public int destoryBankByBankId(Integer bankId) {
		int value = bankMapper.deleteByPrimaryKey(bankId);
		BankTeacherMappingExample example = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = example.createCriteria();
		criteria.andBankidEqualTo(bankId);
		int value2 = bankTeacherMappingMapper.deleteByExample(example);
		
		if(value==1 && value2 == 1) {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public int recoverBankByBankId(Integer bankId) {
		Bank bank = new Bank();
		bank.setDeleteflag(0);
		
		BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bankId);
		int value = bankMapper.updateByExampleSelective(bank, bankExample);
		return value;
	}

	@Override
	public int clearRecycleByUserId(Integer userId) {
		int value2 = bankMapper.deleteBankAndBankTeacherMappingByUserId(userId);
		return value2;
	}

	@Override
	public int recoverBankAllByUserId(Integer userId) {
		int value = bankMapper.recoverBankAllByUserId(userId);
		System.out.println("recoverBankAllByUserId value:"+value);
		return value;
	}

	@Override
	public Integer getQuestionCountByBankId(Integer bankId) {
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andBankidEqualTo(bankId);
		List<Question> list = questionMapper.selectByExample(questionExample);
		return list.size();
	}
}
