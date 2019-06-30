package com.neuedu.web02.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.User;

public interface BankPageHelperService {

	PageInfo<Bank> testPageHelper_info(Integer pageNo, Integer pageSize);
	
	Page<Bank> testPageHelper_page(Integer pageNo, Integer pageSize);
}
