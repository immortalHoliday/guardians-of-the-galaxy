package com.neuedu.web02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.web02.dao.BankMapper;
import com.neuedu.web02.dao.BankTeacherMappingMapper;
import com.neuedu.web02.dao.UserMapper;
import com.neuedu.web02.entity.BankExample;
import com.neuedu.web02.entity.BankTeacherMapping;
import com.neuedu.web02.entity.BankTeacherMappingExample;
import com.neuedu.web02.entity.User;
import com.neuedu.web02.entity.UserExample;
import com.neuedu.web02.service.BankUserService;

@Service
public class BankUserServiceImpl implements BankUserService {
	@Autowired
	BankMapper bankMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	BankTeacherMappingMapper bankTeacherMappingMapper;
	
	@Override
	public User findUserByMail(String userMail) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andMailEqualTo(userMail);
		List<User> list = userMapper.selectByExample(userExample);
		if(0 == list.size()) {
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public User findUserById(Integer userId) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andIdEqualTo(userId);
		List<User> list = userMapper.selectByExample(userExample);
		if(0 == list.size()) {
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public User findUserByBankId(Integer bankId) {
		
		BankTeacherMappingExample example = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = example.createCriteria();
		criteria.andBankidEqualTo(bankId);
		criteria.andStateEqualTo(0);
		
		BankTeacherMapping bankTeacherMapping = bankTeacherMappingMapper.selectByExample(example).get(0);
		User user = userMapper.selectByPrimaryKey(bankTeacherMapping.getTeacherid());
		return user;
	}
	
	
}
