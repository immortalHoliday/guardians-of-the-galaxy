package com.neuedu.web02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.web02.dao.BankMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.service.BankCenterService;
import com.neuedu.web02.service.BankChoiceService;
import com.neuedu.web02.service.BankLabelService;
import com.neuedu.web02.service.BankPageHelperService;
import com.neuedu.web02.service.BankQuestionService;
import com.neuedu.web02.service.BankUserService;

@Controller
public class PageHelperController {
	
	
	@Autowired
	BankCenterService bankService;
	@Autowired
	BankQuestionService questionService;
	@Autowired
	BankLabelService bankLabelService;
	@Autowired
	BankChoiceService bankChoiceService;
	@Autowired
	BankUserService userService;
	@Autowired
	BankPageHelperService pageHelperService;
	
	
	@Autowired
	BankMapper bankMapper;
	
	@RequestMapping("/testPagerHelper")
	@ResponseBody
    public PageInfo<Bank> testPageHelper() {
		PageInfo<Bank> pageinfo = pageHelperService.testPageHelper_info(2, 2);
		
		Page<Bank> page = pageHelperService.testPageHelper_page(2, 2);
		
		List<Bank> list = pageinfo.getList();
		for(Bank temp : list) {
			System.out.println("bankId:"+temp.getId());
		}
		System.out.println("pageinfo:"+pageinfo);
		System.out.println("page:"+page);
		return pageinfo;
	}

}
