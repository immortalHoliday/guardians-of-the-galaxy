package com.neuedu.web02.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.neuedu.web02.dao.BankMapper;
import com.neuedu.web02.dao.OrderInfoMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankTeacherMapping;
import com.neuedu.web02.entity.Label;
import com.neuedu.web02.entity.OrderInfo;
import com.neuedu.web02.entity.Question;
import com.neuedu.web02.entity.ShareItem;
import com.neuedu.web02.entity.User;
import com.neuedu.web02.service.BankCenterService;
import com.neuedu.web02.service.BankChoiceService;
import com.neuedu.web02.service.BankLabelService;
import com.neuedu.web02.service.BankQuestionService;
import com.neuedu.web02.service.BankUserService;
import com.neuedu.web02.util.TimeUtil;

@Controller
public class BankMainPageController {
	
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
	
	//添加一个新的题库，并返回新创建的题库对象
	@RequestMapping(value = "/getLabelData", produces = "application/json;charset=utf-8")
	@ResponseBody
	public  Map GetLabelData(HttpSession session)throws Exception {
		User user = (User)session.getAttribute("user");
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<Label> labelList = bankLabelService.getLabelListByUserId(user.getId());
		List<Bank> bankList = bankService.getAllBank(user.getId());
		List<Question> questionList;
		
		for(Label tempLabel : labelList) {
			map.put(tempLabel.getLabelname(), 0);
		}
		
		for(Bank tempBank : bankList) {
			questionList = questionService.getQuestionListByBankId(tempBank.getId());
			for(Question tempQuestion : questionList) {
				if(-2 != tempQuestion.getLabelid()) {
					String label = bankLabelService.getLabelById(tempQuestion.getLabelid());
					Integer count = (Integer)map.get(label)+1;
					map.put(label, count);
				}
			}
		}
		
		return map;
	}
	
	@RequestMapping("/getBankDiffLevelData")
	@ResponseBody
	//添加一个新的题库，并返回新创建的题库对象
	public  Map GetBankDiffLevelData(HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId)throws Exception {
		List<Question> list = questionService.getQuestionListByBankId(bankId);
		HashMap<String,Object> map = new HashMap<String, Object>();
		Bank bank = bankService.getBanKById(bankId);
		Integer easy=0,mid=0,hard=0;
		for(Question temp : list) {
			if(0 == temp.getDifflevel()) {
				easy++;
			}else if(1 == temp.getDifflevel()){
				mid++;
			}else if(2 == temp.getDifflevel()) {
				hard++;
			}
		}
		
		map.put("bankName", bank.getName());
		map.put("easy", easy);
		map.put("medium", mid);
		map.put("hard", hard);
		return map;
	}
	
	@RequestMapping("/getBankTypeData")
	@ResponseBody
	//添加一个新的题库，并返回新创建的题库对象
	public  Map GetBankTypeData(HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId)throws Exception {
		List<Question> list = questionService.getQuestionListByBankId(bankId);
		HashMap<String,Object> map = new HashMap<String, Object>();
		Bank bank = bankService.getBanKById(bankId);
		Integer singleChoice=0, mutlipleChoice=0, shortQuestion=0;
		for(Question temp : list) {
			if(0 == temp.getTypeid()) {
				singleChoice++;
			}else if(1 == temp.getTypeid()){
				mutlipleChoice++;
			}else if(2 == temp.getTypeid()) {
				shortQuestion++;
			}
		}
		
		map.put("bankName", bank.getName());
		map.put("singleChoice", singleChoice);
		map.put("mutlipleChoice", mutlipleChoice);
		map.put("shortQuestion", shortQuestion);
		return map;
	}
	
	@RequestMapping("/RouteToBankChart")
	//使用模板模式进入进入题库初始页面
	public ModelAndView RouteToBankChart(HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("pages/bankChart");
		Integer bankId = Integer.parseInt(req.getParameter("thisBankId"));
		mav.addObject("thisBankId", bankId);
		
		return mav;
	}
	
	@RequestMapping("/RouteToBankChartTotal")
	//使用模板模式进入进入题库初始页面
	public ModelAndView RouteToBankChartTotal(HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("pages/bankChartTotal");
		mav.addObject("thisBankId", 13);
		
		return mav;
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
	
	
	@RequestMapping("/BankPage")
	//进入题库初始页面
	public String BankPage(HttpSession session) {
		User myUser;
		myUser = userService.findUserById(1);
		session.setAttribute("user", myUser);
		return "pages/index_copy";
	}
			
	@RequestMapping("/BankPageThy")
	//使用模板模式进入进入题库初始页面
	public ModelAndView BankPageThy(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("pages/mybankhomepage");
		
		User myUser;
		myUser = userService.findUserById(1);
		System.out.println("current user:"+myUser.getId());
		session.setAttribute("user", myUser);
		
		/*该用户所有的题库，包括自创题库，收到的分享且已确认的题库，购买的题库还没有加入*/
		ArrayList<Bank> list = bankService.getAllBank(myUser.getId());
		System.out.println("查到的题库数量:"+list.size());
		/*获取所有被分享的题库的映射类，包括未确认的和确认的*/
		ArrayList<BankTeacherMapping> mappingList = bankService.getShareList(myUser.getId());
		System.out.println("题库中分享来的数量:"+mappingList.size());
		/*把自己可以用的分享来的题库和题库创建者的name关联起来*/
		HashMap<Integer, String> bankTeacherMap = new HashMap<Integer, String>();
		/*autMap 把一个题库与对应的权限对应，键为bankid_autid-> 15_2 -> 题库15的2（修改权限）权限，value为1有权限0无权限*/
		HashMap<String, Integer> autMap = new HashMap<String, Integer>();
		
		String autString;
		String autStringArray[];
		Integer count=1;
		
		/*对于每个分享来的题库，把创建人和题库权限加入*/
		for(BankTeacherMapping temp : mappingList) {
			User user = userService.findUserByBankId(temp.getBankid());
			bankTeacherMap.put(temp.getBankid(), user.getName());
			autString = temp.getBackup1();
			autStringArray = autString.split("_");
			for(String tempStr : autStringArray) {
				if(tempStr.equals("1")) {
					autMap.put(temp.getBankid()+"_"+count, 1);
				}else {
					autMap.put(temp.getBankid()+"_"+count, 0);
				}
				count++;
			}
			count=1;
		}
		/*获得一个题库的题目的数量map*/
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Bank temp : list) {
			map.put(temp.getId(), bankService.getQuestionCountByBankId(temp.getId()));
		}
		
		mav.addObject("autMap", autMap);
		mav.addObject("bankList", list);
		mav.addObject("countMap", map);
		mav.addObject("bankTeacherMap", bankTeacherMap);
		System.out.println("mav bankTeacherMap"+mav.getModel().toString());
		System.out.println("mav bankList"+mav.getModel().toString());
		return mav;
	}
	
	@RequestMapping("/BankRecycleThy")
	//使用模板模式进入进入题库初始页面
	public ModelAndView BankRecycleThy(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("pages/mybankrecycle");
		User myUser = (User)session.getAttribute("user");
		ArrayList<Bank> list = bankService.getRecycleList(myUser.getId());
		
		
		/*获取所有被分享的题库的映射类，包括未确认的和确认的*/
		ArrayList<BankTeacherMapping> mappingList = bankService.getShareList(myUser.getId());
		System.out.println("题库中分享来的数量:"+mappingList.size());
		/*把自己可以用的分享来的题库和题库创建者的name关联起来*/
		HashMap<Integer, String> bankTeacherMap = new HashMap<Integer, String>();
		/*autMap 把一个题库与对应的权限对应，键为bankid_autid-> 15_2 -> 题库15的2（修改权限）权限，value为1有权限0无权限*/
		HashMap<String, Integer> autMap = new HashMap<String, Integer>();
		
		String autString;
		String autStringArray[];
		Integer count=1;
		
		/*对于每个分享来的题库，把创建人和题库权限加入*/
		for(BankTeacherMapping temp : mappingList) {
			User user = userService.findUserByBankId(temp.getBankid());
			bankTeacherMap.put(temp.getBankid(), user.getName());
			autString = temp.getBackup1();
			autStringArray = autString.split("_");
			for(String tempStr : autStringArray) {
				if(tempStr.equals("1")) {
					autMap.put(temp.getBankid()+"_"+count, 1);
				}else {
					autMap.put(temp.getBankid()+"_"+count, 0);
				}
				count++;
			}
			count=1;
		}
		/*获得一个题库的题目的数量map*/
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Bank temp : list) {
			map.put(temp.getId(), bankService.getQuestionCountByBankId(temp.getId()));
		}
		
		mav.addObject("autMap", autMap);
		mav.addObject("bankList", list);
		mav.addObject("countMap", map);
		mav.addObject("bankTeacherMap", bankTeacherMap);
		return mav;
	}
	
	@RequestMapping("/BankArchiveThy")
	//使用模板模式进入进入题库初始页面
	public ModelAndView BankArchiveThy(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("pages/mybankarchive");
		User myUser = (User)session.getAttribute("user");
		ArrayList<Bank> list = bankService.getArchiveList(myUser.getId());
		
		
		/*获取所有被分享的题库的映射类，包括未确认的和确认的*/
		ArrayList<BankTeacherMapping> mappingList = bankService.getShareList(myUser.getId());
		System.out.println("题库中分享来的数量:"+mappingList.size());
		/*把自己可以用的分享来的题库和题库创建者的name关联起来*/
		HashMap<Integer, String> bankTeacherMap = new HashMap<Integer, String>();
		/*autMap 把一个题库与对应的权限对应，键为bankid_autid-> 15_2 -> 题库15的2（修改权限）权限，value为1有权限0无权限*/
		HashMap<String, Integer> autMap = new HashMap<String, Integer>();
		
		String autString;
		String autStringArray[];
		Integer count=1;
		
		/*对于每个分享来的题库，把创建人和题库权限加入*/
		for(BankTeacherMapping temp : mappingList) {
			User user = userService.findUserByBankId(temp.getBankid());
			bankTeacherMap.put(temp.getBankid(), user.getName());
			autString = temp.getBackup1();
			autStringArray = autString.split("_");
			for(String tempStr : autStringArray) {
				if(tempStr.equals("1")) {
					autMap.put(temp.getBankid()+"_"+count, 1);
				}else {
					autMap.put(temp.getBankid()+"_"+count, 0);
				}
				count++;
			}
			count=1;
		}
		/*获得一个题库的题目的数量map*/
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Bank temp : list) {
			map.put(temp.getId(), bankService.getQuestionCountByBankId(temp.getId()));
		}
		
		mav.addObject("autMap", autMap);
		mav.addObject("bankList", list);
		mav.addObject("countMap", map);
		mav.addObject("bankTeacherMap", bankTeacherMap);
		return mav;
	}
	
	private HashMap<Integer,Integer> getAutList(String autStr){
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		String[] strList = autStr.split("_");
		Integer count = 1;
		for(String temp : strList) {
			if(temp.equals("1")) {
				map.put(count,1);
			}else {
				map.put(count,0);
			}
			count++;
		}
		
		return map;
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
	
	@RequestMapping("/bankArchive")
	//将题库加入回收站	
	public 	@ResponseBody String BankArchive(
			@RequestParam(value="bankId",required=true) Integer bankId) {
		
		int value = bankService.bankArchive(bankId);
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
	//在回收站彻底删除一个题库，及一个题库的所有题，及所有题的所有选项
	public 	@ResponseBody String BankDestory(
			HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId) {
		System.out.println("彻底删除题库："+bankId);
		//若是别人分享来的题库，只需要删掉映射表即可
		int value = 0;
		User user = (User)session.getAttribute("user");
		
		BankTeacherMapping btm = bankService.findBTMByPrimaryKey(bankId, user.getId());
		int state = btm.getState();
		
		if(0 == state) {
			System.out.println("彻底删除的私人题库");
			// TODO
//			value = bankService.destoryBankByBankId(bankId);
		}else {
			System.out.println("彻底删除的分享来的题库");
			// TODO
//			value = bankService.deleteBankTeacherMappingByBankIdAndTeaId(bankId, user.getId());
		}
		
		System.out.println("destory value:"+value);
		
		if(1 == value) {
			return "ok";
		}else {
			// TODO ok 改为 error
			return "ok";
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
	//在回收站恢复所有题库	
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
	//清空回收站，删除所有题库，及所有题库的问题，及所有问题选项
	public 	@ResponseBody String RecycleClear(HttpSession session) {
		User user = (User)session.getAttribute("user");
		System.out.println("clear userid:"+user.getId());
		int value = 0;
		
		ArrayList<Bank> recycleBankList = bankService.getRecycleList(user.getId());
		BankTeacherMapping btm;
		for(Bank tempBank : recycleBankList) {
			btm = bankService.findBTMByPrimaryKey(tempBank.getId(), user.getId());
			if(0 == btm.getState()) {
				System.out.println("进入回收站的是自己的题库");
				// TODO
//				value += bankService.destoryBankByBankId(tempBank.getId());
			}else {
				System.out.println("进入回收站的分享来的题库");
				// TODO
//				value += bankService.deleteBankTeacherMappingByBankIdAndTeaId(tempBank.getId(), user.getId());
			}
		}
		
		System.out.println("clear value:"+value);
		
		if(0 == value) {
			// TODO ok 改为  error
			return "ok";
		}else {
			return "ok";
		}
	}
	
	@RequestMapping("/findUser")
	//处理在分享过程中，填写用户邮箱，实时获取用户信息的方法
	public 	@ResponseBody Map FindUser(
			HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId,
			@RequestParam(value="userMail",required=true) String userMail) {
		
		System.out.println("bankId:"+bankId+" userMail:"+userMail);
		HashMap<String, Object> map = new HashMap<String, Object>();
		User user = (User)session.getAttribute("user");
		
		User toUser = userService.findUserByMail(userMail);
		
		
		
		if(null == toUser || 1!=toUser.getRole()) {
			//没有对应邮箱的user 或者用户非教师
			System.out.println("from "+user.getId()+" to nobody or no teacher");
			map.put("username", null);
			map.put("userId", null);
		}else { 
			BankTeacherMapping btm = bankService.findBTMByPrimaryKey(bankId, toUser.getId());
			if(null == btm){
				/*这是一条新分享*/
				System.out.println("这是条新分享");
				System.out.println("from "+user.getId()+" to "+toUser.getId());
				map.put("username", toUser.getName());
				map.put("userId", toUser.getId());
			}else {
				/*这是一条已存在的分享*/
				System.out.println("这是已存在的分享");
				map.put("username", toUser.getId());
				map.put("userId", toUser.getId());
				map.put("state", "exists");
				return map;
			}
		}
		
		return map;
	}
	
	@RequestMapping("/shareBankToUser")
	//处理一个用户分享题库的操作
	public 	@ResponseBody String ShareBankToUser(
			HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId,
			@RequestParam(value="userId",required=true) Integer userId,
			@RequestParam(value="autArray",required=true) String jsonStrArray) {
		
		User fromUser = (User)session.getAttribute("user");
		User toUser = userService.findUserById(userId);
		/*获取权限*/
		JSONArray autList = JSONArray.parseArray(jsonStrArray);
		String autStr = new String();
		for(int i=0; i<autList.size(); i++) {
			autStr += autList.get(i)+"_";
		}
		System.out.println("autStr:"+autStr);
		if(toUser.getId() == fromUser.getId()) {
			return "error";
		}
		
		Bank bank = bankService.getBanKById(bankId);
		int value =0;
		value = bankService.shareABank(bankId, userId, autStr);
		System.out.println("分享题库返回值："+value);
		
		return ""+value;
	}
	
	@RequestMapping("/BankShareThy")
	//使用模板模式进入进入分享初始页面
	public ModelAndView BankShareThy(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("pages/mybankshare");
		
		User myUser = (User)session.getAttribute("user");
		ShareItem si;
		Bank bank;
		User toUser,fromUser;
		ArrayList<ShareItem> toMeItemList = new ArrayList<ShareItem>(), fromMeItemList = new ArrayList<ShareItem>();
		/*toList表示是别人分享给我的题库映射表*/
		ArrayList<BankTeacherMapping> toMeList = bankService.getShareList(myUser.getId());
		/*fromList表示是我分享给别人的题库映射表*/
		ArrayList<BankTeacherMapping> fromMeList = bankService.getShareFromMeList(myUser.getId());
		
		HashMap<String, String> toMeMap = new HashMap<String, String>(),fromMeMap = new HashMap<String, String>();
		
		String[] auths;
		String auth;
		int count = 1;
		
		for(BankTeacherMapping temp : fromMeList) {
			bank = bankService.getBanKById(temp.getBankid());
			fromUser = myUser;
			toUser = userService.findUserById(temp.getTeacherid());
			si = new ShareItem(fromUser, toUser, bank, temp.getState());
			fromMeItemList.add(si);
			System.out.println("from-用户"+fromUser.getId()+"把题库"+temp.getBankid()+"分享给用户"+toUser.getId());
			BankTeacherMapping btm = bankService.findBTMByPrimaryKey(bank.getId(), toUser.getId());
			auth = btm.getBackup1();
			System.out.println("题库"+bank.getId()+"的权限"+auth);
			auths = auth.split("_");
			System.out.println("1auths.length:"+auths.length);
			for(int i=0; i<auths.length; i++,count++) {
				fromMeMap.put(toUser.getId()+"_"+bank.getId()+"_"+ count, auths[i]);
			}
			count=1;
		}
		count = 1;
		for(BankTeacherMapping temp : toMeList) {
			bank = bankService.getBanKById(temp.getBankid());
			toUser = myUser;
			fromUser = userService.findUserByBankId(bank.getId());
			si = new ShareItem(fromUser, toUser, bank, temp.getState());
			toMeItemList.add(si);
			System.out.println("to-用户"+fromUser.getId()+"把题库"+temp.getBankid()+"分享给用户"+toUser.getId());
			auth = temp.getBackup1();
			auths = auth.split("_");
			System.out.println("2auths.length:"+auths.length);
			for(int i=0; i<auths.length; i++,count++) {
				toMeMap.put(fromUser.getId()+"_"+bank.getId()+"_"+ count, auths[i]);
			}
			count=1;
		}
		
		mav.addObject("fromMeMap", fromMeMap);
		mav.addObject("toMeMap", toMeMap);
		mav.addObject("fromMeItemList", fromMeItemList);
		mav.addObject("toMeItemList", toMeItemList);
		
		System.out.println(mav.getModel());
		return mav;
	}
	
	
	@RequestMapping("/initPagination")
	@ResponseBody
	public Map InitPagination(
			HttpSession session,
			@RequestParam(value="pageNum",required=true) Integer pageNum,
			@RequestParam(value="pageSize",required=true) Integer pageSize) {
		
		System.out.println("pageNum:"+pageNum+" pageSize:"+pageSize);
		User myUser = (User)session.getAttribute("user");
		
		ShareItem si;
		Bank bank;
		User toUser,fromUser;
		ArrayList<ShareItem> toMeItemList = new ArrayList<ShareItem>(), fromMeItemList = new ArrayList<ShareItem>();
		
		
		/*toList表示是别人分享给我的题库映射表*/
		/*这里要指定页数和每页的显示条数*/
		PageInfo<BankTeacherMapping> toMeList = bankService.getShareListPage(pageNum ,pageSize ,myUser.getId());
		/*fromList表示是我分享给别人的题库映射表*/
		/*这里要指定页数和每页的显示条数*/
		PageInfo<BankTeacherMapping> fromMeList = bankService.getShareFromMeListPage(pageNum ,pageSize ,myUser.getId());
		
		HashMap<String, String> toMeMap = new HashMap<String, String>(),fromMeMap = new HashMap<String, String>();
		
		String[] auths;
		String auth;
		int count = 1;
		
		for(BankTeacherMapping temp : fromMeList.getList()) {
			bank = bankService.getBanKById(temp.getBankid());
			fromUser = myUser;
			toUser = userService.findUserById(temp.getTeacherid());
			si = new ShareItem(fromUser, toUser, bank, temp.getState());
			fromMeItemList.add(si);
			System.out.println("from-用户"+fromUser.getId()+"把题库"+temp.getBankid()+"分享给用户"+toUser.getId());
			BankTeacherMapping btm = bankService.findBTMByPrimaryKey(bank.getId(), toUser.getId());
			auth = btm.getBackup1();
			System.out.println("题库"+bank.getId()+"的权限"+auth);
			auths = auth.split("_");
			System.out.println("1auths.length:"+auths.length);
			for(int i=0; i<auths.length; i++,count++) {
				fromMeMap.put(toUser.getId()+"_"+bank.getId()+"_"+ count, auths[i]);
			}
			count=1;
		}
		count = 1;
		for(BankTeacherMapping temp : toMeList.getList()) {
			bank = bankService.getBanKById(temp.getBankid());
			toUser = myUser;
			fromUser = userService.findUserByBankId(bank.getId());
			si = new ShareItem(fromUser, toUser, bank, temp.getState());
			toMeItemList.add(si);
			System.out.println("to-用户"+fromUser.getId()+"把题库"+temp.getBankid()+"分享给用户"+toUser.getId());
			auth = temp.getBackup1();
			auths = auth.split("_");
			System.out.println("2auths.length:"+auths.length);
			for(int i=0; i<auths.length; i++,count++) {
				toMeMap.put(fromUser.getId()+"_"+bank.getId()+"_"+ count, auths[i]);
			}
			count=1;
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("fromMeMap", fromMeMap);
		map.put("toMeMap", toMeMap);
		map.put("fromMeItemList", fromMeItemList);
		map.put("toMeItemList", toMeItemList);
		map.put("toMeList", toMeList);
		map.put("fromMeList", fromMeList);
		map.put("pageNum", pageNum);
		return map;
	}
	
	
	@RequestMapping("/BankShareThyPage")
	//使用模板模式进入进入分享初始页面
	public ModelAndView BankShareThyPage(
			HttpSession session,
			@RequestParam(value="pageNum",required=true) Integer pageNum,
			@RequestParam(value="pageSize",required=true) Integer pageSize,
			@RequestParam(value="initTable",required=true) Integer initTable) {
		
		ModelAndView mav = new ModelAndView("pages/mybankshareV2");
		
		User myUser = (User)session.getAttribute("user");
		ShareItem si;
		Bank bank;
		User toUser,fromUser;
		ArrayList<ShareItem> toMeItemList = new ArrayList<ShareItem>(), fromMeItemList = new ArrayList<ShareItem>();
		
		/*toList表示是别人分享给我的题库映射表*/
		/*这里要指定页数和每页的显示条数*/
		PageInfo<BankTeacherMapping> toMeList = bankService.getShareListPage(pageNum ,pageSize ,myUser.getId());
		/*fromList表示是我分享给别人的题库映射表*/
		/*这里要指定页数和每页的显示条数*/
		PageInfo<BankTeacherMapping> fromMeList = bankService.getShareFromMeListPage(pageNum ,pageSize ,myUser.getId());
		
		HashMap<String, String> toMeMap = new HashMap<String, String>(),fromMeMap = new HashMap<String, String>();
		
		String[] auths;
		String auth;
		int count = 1;
		
		for(BankTeacherMapping temp : fromMeList.getList()) {
			bank = bankService.getBanKById(temp.getBankid());
			fromUser = myUser;
			toUser = userService.findUserById(temp.getTeacherid());
			si = new ShareItem(fromUser, toUser, bank, temp.getState());
			fromMeItemList.add(si);
			System.out.println("from-用户"+fromUser.getId()+"把题库"+temp.getBankid()+"分享给用户"+toUser.getId());
			BankTeacherMapping btm = bankService.findBTMByPrimaryKey(bank.getId(), toUser.getId());
			auth = btm.getBackup1();
			System.out.println("题库"+bank.getId()+"的权限"+auth);
			auths = auth.split("_");
			System.out.println("1auths.length:"+auths.length);
			for(int i=0; i<auths.length; i++,count++) {
				fromMeMap.put(toUser.getId()+"_"+bank.getId()+"_"+ count, auths[i]);
			}
			count=1;
		}
		count = 1;
		for(BankTeacherMapping temp : toMeList.getList()) {
			bank = bankService.getBanKById(temp.getBankid());
			toUser = myUser;
			fromUser = userService.findUserByBankId(bank.getId());
			si = new ShareItem(fromUser, toUser, bank, temp.getState());
			toMeItemList.add(si);
			System.out.println("to-用户"+fromUser.getId()+"把题库"+temp.getBankid()+"分享给用户"+toUser.getId());
			auth = temp.getBackup1();
			auths = auth.split("_");
			System.out.println("2auths.length:"+auths.length);
			for(int i=0; i<auths.length; i++,count++) {
				toMeMap.put(fromUser.getId()+"_"+bank.getId()+"_"+ count, auths[i]);
			}
			count=1;
		}
		
		mav.addObject("initTable", initTable);
		mav.addObject("fromMeMap", fromMeMap);
		mav.addObject("toMeMap", toMeMap);
		mav.addObject("fromMeItemList", fromMeItemList);
		mav.addObject("toMeItemList", toMeItemList);
		
		System.out.println(mav.getModel());
		
		/* 在这里加载好第一页的数据之后，在前端模板上显示第一页的数据。再在$(function(){ $ajax->进入到另一个controller})方法初始化分页条 */
		return mav;
	}
	
	
	
	@RequestMapping("/addShareToBank")
	//清空回收站
	public 	@ResponseBody String AddShareToBank(
			HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId) {
		System.out.println("bankId:"+bankId);
		User user = (User)session.getAttribute("user");
		/*把一个用户的为添加至题库的题库添加至题库*/
		int value = bankService.updateBankTeacherMappingState(bankId, user.getId(), 2);
		
		return ""+value;
	}
	
	@RequestMapping("/setShareAut")
	//清空回收站
	public 	@ResponseBody String SetShareAut(
			HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId,
			@RequestParam(value="userId",required=true) Integer userId,
			@RequestParam(value="arrayJson",required=true) String arrayJson) {
		
		System.out.println("修改用户"+userId+"的题库"+bankId+"的权限为"+arrayJson);
		JSONArray autList = JSONArray.parseArray(arrayJson);
		String aut = new String();
		for(int i=0; i<autList.size(); i++) {
			aut += autList.getString(i)+"_";
		}
		
		System.out.println("权限字符串："+aut);
		
		int value = bankService.updateAutByBankIdAndTeaId(bankId, userId, aut);
		return ""+value;
	}
	
	@RequestMapping("/getInfoForModal")
	//处理在分享过程中，填写用户邮箱，实时获取用户信息的方法
	public 	@ResponseBody Map getInfoForModal(
			HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId,
			@RequestParam(value="userId",required=true) Integer userId) {
		Bank bank = bankService.getBanKById(bankId);
		User user = userService.findUserById(userId);
		BankTeacherMapping btm = bankService.findBTMByPrimaryKey(bank.getId(), user.getId());
		String aut = btm.getBackup1();
		String[] autStr = aut.split("_");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("bank", bank);
		map.put("user", user);
		map.put("auts", autStr);
		
		return map;
	}
	
	@RequestMapping("/cancelShare")
	//处理在分享过程中，填写用户邮箱，实时获取用户信息的方法
	public 	@ResponseBody String CancelShare(
			HttpSession session,
			@RequestParam(value="bankId",required=true) Integer bankId,
			@RequestParam(value="userId",required=true) Integer userId) {

		User user = (User)session.getAttribute("user");
		System.out.println("用户"+user.getId()+"撤销对于用户"+userId+"关于"+bankId+"题库的分享");
		// TODO 把下面的注释去掉
//		int value = bankService.deleteBankTeacherMappingByBankIdAndTeaId(bankId, userId);
		//if(1 == value){ return "ok";}else{return "error";}
		
		return null;
	}
	
}
