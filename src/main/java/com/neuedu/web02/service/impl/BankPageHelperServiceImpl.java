package com.neuedu.web02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.web02.dao.BankMapper;
import com.neuedu.web02.dao.UserMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankExample;
import com.neuedu.web02.entity.User;
import com.neuedu.web02.service.BankPageHelperService;

@Service
public class BankPageHelperServiceImpl implements BankPageHelperService {

	@Autowired
	BankMapper bankMapper;

	@Override
	public PageInfo<Bank> testPageHelper_info(Integer pageNo, Integer pageSize) {
		Object obj = PageHelper.startPage(pageNo, pageSize);
		BankExample example = new BankExample();
		BankExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteflagEqualTo(0);
		System.out.println("obj:"+obj);
		List<Bank> list = bankMapper.selectByExample(example);
		//用PageInfo对结果进行包装
        PageInfo<Bank> page = new PageInfo<Bank>(list);
		return page;
	}

	@Override
	public Page<Bank> testPageHelper_page(Integer pageNo, Integer pageSize) {
		Object obj = PageHelper.startPage(pageNo, pageSize);
		BankExample example = new BankExample();
		BankExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteflagEqualTo(0);
		System.out.println("obj:"+obj);
		//用PageInfo对结果进行包装
        Page<Bank> page = (Page<Bank>) bankMapper.selectByExample(example);
		return page;
	}
	
	
}
