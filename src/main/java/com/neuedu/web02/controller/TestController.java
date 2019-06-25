package com.neuedu.web02.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.web02.dao.UserMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.User;
import com.neuedu.web02.service.BankCenterService;

@Controller
public class TestController {
	@Autowired
	UserMapper userMapper;

	@RequestMapping("/web02-test")
	@ResponseBody
	public String firstTest() {
		return "这是web02工程的第一个测试";
	}
	
	@RequestMapping("/web02-test2")
	public String Test2() {
		return "pages/test/test";
	}
	
	@RequestMapping("/web02-test3")
	public ModelAndView Test3() {
		ModelAndView modelandview = new ModelAndView();/*包装、传递页面，传递数据*/
		modelandview.setViewName("test/test");
//		modelandview.addObject("name1","四进四信");
		return modelandview;
	}
	
	@RequestMapping("/testpage")
	public String TestPage() {
		return "pages/index_copy.html";
	}
	
	@RequestMapping("/web02-test4")
	@ResponseBody
	public String Test4() {
		User user = new User();
		user.setName("tom");
		user.setPassword("123");
		user.setRole(1);
		userMapper.insert(user);
		return "查看数据库 是否插入成功";
	}

}
