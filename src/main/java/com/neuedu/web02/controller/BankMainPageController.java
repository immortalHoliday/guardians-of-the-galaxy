package com.neuedu.web02.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.web02.dao.BankMapper;
import com.neuedu.web02.dao.OrderInfoMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.OrderInfo;
import com.neuedu.web02.entity.User;
import com.neuedu.web02.service.BankCenterService;
import com.neuedu.web02.util.TimeUtil;

@Controller
public class BankMainPageController {

	@Autowired
	BankCenterService bankService;
	
	
	@RequestMapping("/BankPage")
	//进入题库初始页面
	public String BankPage(HttpSession session) {
		User myUser = new User();
		myUser.setId(1);
		myUser.setName("静");
		myUser.setPassword("test");
		myUser.setRole(1);
		session.setAttribute("user", myUser);
		return "pages/index_copy";
	}
			
	@RequestMapping("/BankPageThy")
	//使用模板模式进入进入题库初始页面
	public ModelAndView BankPageThy(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("pages/mybankhomepage");
		
		User myUser = new User();
		myUser.setId(1);
		myUser.setName("静");
		myUser.setPassword("test");
		myUser.setRole(1);
		session.setAttribute("user", myUser);
		
		ArrayList<Bank> list = bankService.getAllBank(myUser.getId());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Bank temp : list) {
			map.put(temp.getId(), bankService.getQuestionCountByBankId(temp.getId()));
		}
		mav.addObject("bankList", list);
		mav.addObject("countMap", map);
		return mav;
	}
	
	@RequestMapping("/BankRecycleThy")
	//使用模板模式进入进入题库初始页面
	public ModelAndView BankRecycleThy(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("pages/mybankrecycle");
		
		User myUser = (User)session.getAttribute("user");
		
		ArrayList<Bank> list = bankService.getRecycleList(myUser.getId());
		mav.addObject("bankList", list);
		System.out.println("bankList:"+list);
		return mav;
	}
	
	@RequestMapping("/initBankPage")
	@ResponseBody
	//初始化题库主页面，加载题库信息
	public  Map initBankPage(HttpSession session)throws Exception {
		User myUser = (User)session.getAttribute("currentUser");
		
		ArrayList<Bank> list = bankService.getAllBank(myUser.getId());
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("bankList", list);
		return map;
	}
	
	@RequestMapping("/addNewBank")
	@ResponseBody
	//添加一个新的题库，并返回新创建的题库对象
	public  Map addNewBank(HttpSession session, @RequestBody Bank bank)throws Exception {
		System.out.println("addNewBank:"+bank.getName()+" "+bank.getDescription());
		bank.setTime(new Date());
		User user = (User)session.getAttribute("user");
		
		Bank newBank = bankService.insertBank(bank);
		
		bankService.insertIntoBankTeacherMapping(user.getId(), newBank.getId());
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("newBank", newBank);
		return map;
	}
	
	@RequestMapping("/bankIntoRecycle")
	//将题库加入回收站	
	public 	@ResponseBody String BankIntoRecycle(
			@RequestParam(value="bankId",required=true) Integer bankId) {
		
		int value = bankService.bankIntoRecycle(bankId);
		if(1 == value) {
			return "ok";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/bankEditHandler")
	//处理编辑题库的操作	
	public 	@ResponseBody String BankEditHandler(@RequestBody Bank bank) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Integer value = bankService.editBank(bank);
		
		return value.toString();
	}
	
	@RequestMapping("/bankDestoryById")
	//在回收站彻底删除一个题库
	public 	@ResponseBody String BankDestory(
			@RequestParam(value="bankId",required=true) Integer bankId) {
		System.out.println("彻底删除题库："+bankId);
		int value = bankService.destoryBankByBankId(bankId);
		System.out.println("destory value:"+value);
		if(1 == value) {
			return "ok";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/bankRecoverById")
	//在回收站恢复一个题库	
	public 	@ResponseBody String BankRecoverById(
			@RequestParam(value="bankId",required=true) Integer bankId) {
		System.out.println("恢复题库："+bankId);
		int value = bankService.recoverBankByBankId(bankId);
		System.out.println("recover value:"+value);
		
		if(1 == value) {
			return "ok";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/recycleRecoverAll")
	//在回收站恢复一个题库	
	public 	@ResponseBody String RecycleRecoverAll(HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		int value = bankService.recoverBankAllByUserId(user.getId());
		
		if(0 == value) {
			return "not ok";
		}else {
			return "ok";
		}
	}
	
	
	@RequestMapping("/recycleClear")
	//清空回收站
	public 	@ResponseBody String RecycleClear(HttpSession session) {
		User user = (User)session.getAttribute("user");
		System.out.println("clear userid:"+user.getId());
		
		int value = bankService.clearRecycleByUserId(user.getId());
		
		System.out.println("clear value:"+value);
		
		if(0 == value) {
			return "not ok";
		}else {
			return "ok";
		}
	}
	
}
