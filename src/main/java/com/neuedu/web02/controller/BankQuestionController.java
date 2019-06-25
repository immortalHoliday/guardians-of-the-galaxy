package com.neuedu.web02.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.Choice;
import com.neuedu.web02.entity.Label;
import com.neuedu.web02.entity.Question;
import com.neuedu.web02.entity.User;
import com.neuedu.web02.service.BankCenterService;
import com.neuedu.web02.service.BankChoiceService;
import com.neuedu.web02.service.BankLabelService;
import com.neuedu.web02.service.BankQuestionService;

@Controller
public class BankQuestionController {
	
	@Autowired
	BankCenterService bankService;
	@Autowired
	BankQuestionService questionService;
	@Autowired
	BankLabelService bankLabelService;
	@Autowired
	BankChoiceService bankChoiceService;
	
	
	@RequestMapping("/bankAddQuestionPage")
	//进入题库初始页面
	public ModelAndView BankAddQuestionPage(HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("pages/bankAddQuestion");
		Integer bankId = Integer.parseInt(req.getParameter("thisId"));
		User myUser = (User)session.getAttribute("user");
		Bank bank = bankService.getBanKById(bankId);
		
		List<Label> labelList = bankLabelService.getLabelListByUserId(myUser.getId());
		System.out.println("bankAddQuestionPage-bankId:"+bankId);
		System.out.println("myUser:"+myUser.getName());
		System.out.println("labelList.size():"+labelList.size());
		
		session.setAttribute("bank", bank);
		mav.addObject("bank", bank);
		mav.addObject("labelList", labelList);
		return mav;
	}

	
//	笨办法
	@RequestMapping("/bankAddSingleChoice")
	@ResponseBody
	public String BankAddSingleChoice(HttpSession session,
			@RequestParam(value="typeid",required=true) Integer typeid,
			@RequestParam(value="difflevel",required=true) Integer difflevel,
			@RequestParam(value="labelid",required=true) Integer labelid,
			@RequestParam(value="labeltext",required=true) String labeltext,
			@RequestParam(value="answer",required=true) String answer,
			@RequestParam(value="description") String description,
			@RequestParam(value="analysis") String analysis,
			@RequestParam(value="answerArray") String answerArray
			) {
		
		System.out.println("------------------------------");
		System.out.println("typeid:"+typeid);
		System.out.println("difflevel:"+difflevel);
		System.out.println("labelid:"+labelid);
		System.out.println("labeltext:"+labeltext);
		System.out.println("answer:"+answer);
		System.out.println("description:"+description);
		System.out.println("analysis:"+analysis);
		System.out.println("answerArray:"+answerArray);
		
		return "ok";
	}
	
//	测试使用
	@RequestMapping("/test")
	@ResponseBody
	public String Test(@RequestBody JSONObject params) {
		
		System.out.println("params:"+params);
//		System.out.println("params string:"+params.toString());
		return "ok";
	}
	
	@RequestMapping("/addSingleQuestionByJson")
	@ResponseBody
	public String AddSingleQuestionByJson(HttpSession session, @RequestBody JSONObject params) {
		
		System.out.println("params:"+params);
//		System.out.println("params string:"+params.toString());
		
		Bank bank = (Bank)session.getAttribute("bank");
		User user = (User)session.getAttribute("user");
		
		//	题型
		Integer typeid = params.getInteger("typeid");
		//	难度
		Integer difflevel = params.getInteger("difflevel");
		//	非答案选项
		String array = params.getString("nonAnswerArray");
		List<String> choiceList = (List<String>)params.parse(array);
		//	题目知识
		Integer labelid = params.getInteger("labelid");
		String labeltext = params.getString("labeltext");
		//	答案
		String answerStr = params.getString("answerArray");
		List<String> answerArray = (List<String>)params.parse(answerStr);
		String answer = answerArray.get(0);
		//  题干
		String description = params.getString("description");
		//	解析
		String analysis = params.getString("analysis");
		
		Question newQuestion = new Question();
		newQuestion.setBankid(bank.getId());
		newQuestion.setDescription(description);
		newQuestion.setDifflevel(difflevel);
		newQuestion.setAnalysis(analysis);
		newQuestion.setTypeid(typeid);
		//此知识点是新的
			if(-1 == labelid){
				Label newLabel = new Label();
				newLabel.setLabelname(labeltext);
				newLabel.setBackup2(user.getId());
				labelid = bankLabelService.insertLabel(newLabel);
			}else if(-2 == labelid){
				
			}
		newQuestion.setLabelid(labelid);
		Integer questionId = questionService.insertSingleChoice(newQuestion);
		System.out.println("questionid:"+questionId);
		
		Choice tempChoice,choiceAnswer = new Choice();
		choiceAnswer.setContent(answer);
		choiceAnswer.setQuestionid(questionId);
		Integer choiceAnswerId = bankChoiceService.insertSingleChoice(choiceAnswer);
		System.out.println("choiceAnswerId:"+choiceAnswerId);
		
		newQuestion.setAnswer(choiceAnswerId.toString());
		
		for(String temp : choiceList) {
			tempChoice = new Choice();
			tempChoice.setContent(temp);
			tempChoice.setQuestionid(questionId);
			Integer tempChoiceId = bankChoiceService.insertSingleChoice(tempChoice);
			System.out.println("tempChoiceId:"+tempChoiceId);
		}
		
//      System.out.println("typeid:"+typeid);
//		System.out.println("difflevel:"+difflevel);
//		System.out.println("list.size"+list.size());
//		System.out.println("labelid:"+labelid);
//		System.out.println("labeltext:"+labeltext);
//		System.out.println("answer:"+answer);
//		System.out.println("description:"+description);
//		System.out.println("analysis:"+analysis);
		return "ok";
	}
	
//	多选题、单选题都用此方法
	@RequestMapping("/addMutlipleQuestionByJson")
	@ResponseBody
	public String AddMutlipleQuestionByJson(HttpSession session, @RequestBody JSONObject params) {
		System.out.println("params:"+params);
		//	当前用户和当前题库	
		Bank bank = (Bank)session.getAttribute("bank");
		User user = (User)session.getAttribute("user");
		//	题型
		Integer typeid = params.getInteger("typeid");
		//	难度
		Integer difflevel = params.getInteger("difflevel");
		//	题目知识
		Integer labelid = params.getInteger("labelid");
		String labeltext = params.getString("labeltext");
		//  题干
		String description = params.getString("description");
		//	解析
		String analysis = params.getString("analysis");
		//	答案
		String answerStr = params.getString("answerArray");
		List<String> answerList = (List<String>)params.parse(answerStr);
		//	非答案选项
		String array = params.getString("nonAnswerArray");
		System.out.println("array:"+array);
		List<String> choiceList = (List<String>)params.parse(array);
		//  创建新的题目		
		Question newQuestion = new Question();
		newQuestion.setBankid(bank.getId());
		newQuestion.setDescription(description);
		newQuestion.setDifflevel(difflevel);
		newQuestion.setAnalysis(analysis);
		newQuestion.setTypeid(typeid);
		//判断是否为新知识点或者知识点选项为空
		if(-1 == labelid){
			Label newLabel = new Label();
			newLabel.setLabelname(labeltext);
			newLabel.setBackup2(user.getId());
			labelid = bankLabelService.insertLabel(newLabel);
		}else if(-2 == labelid){
			
		}
		//	添加知识点，并创建新题返回题目id，因为创建选项需要题目id
		newQuestion.setLabelid(labelid);
		Integer questionId = questionService.insertSingleChoice(newQuestion);
		System.out.println("questionid:"+questionId);
		//	处理答案和非答案选项部分
		Choice tempChoice;
		String answerString = "";
		//	答案部分
		for(String temp : answerList) {
			tempChoice = new Choice();
			tempChoice.setContent(temp);
			tempChoice.setQuestionid(questionId);
			Integer tempChoiceId = bankChoiceService.insertSingleChoice(tempChoice);
			System.out.println("tempAnswerChoiceId:"+tempChoiceId);
			answerString += tempChoiceId+"_";
		}
		System.out.println("answerString:"+answerString);
		//	将答案选项字符串传给新题
		newQuestion.setAnswer(answerString);
		Integer value = questionService.updateAnswerChoice(newQuestion);
		System.out.println("value:"+value);
		//	非答案选项	
		for(String temp : choiceList) {
			tempChoice = new Choice();
			tempChoice.setContent(temp);
			tempChoice.setQuestionid(questionId);
			Integer tempChoiceId = bankChoiceService.insertSingleChoice(tempChoice);
			System.out.println("tempChoiceId:"+tempChoiceId);
		}
		return "ok";
	}
	
	@RequestMapping("/addShortQuestionByJson")
	@ResponseBody
	public String AddShortQuestionByJson(HttpSession session, @RequestBody JSONObject params) {
		
		System.out.println("params:"+params);
		//	当前用户和当前题库	
		Bank bank = (Bank)session.getAttribute("bank");
		User user = (User)session.getAttribute("user");
		
		//	题型
		Integer typeid = params.getInteger("typeid");
		//	难度
		Integer difflevel = params.getInteger("difflevel");
		//	题目知识
		Integer labelid = params.getInteger("labelid");
		String labeltext = params.getString("labeltext");
		//  题干
		String description = params.getString("description");
		//	解析
		String analysis = params.getString("analysis");
		//	参考答案
		String referAnswer = params.getString("referAnswer");
		System.out.println("referAnswer:"+referAnswer);
		
		//  创建新的题目		
		Question newQuestion = new Question();
		newQuestion.setBankid(bank.getId());
		newQuestion.setDescription(description);
		newQuestion.setDifflevel(difflevel);
		newQuestion.setAnalysis(analysis);
		newQuestion.setTypeid(typeid);
		newQuestion.setAnswer(referAnswer);
		//判断是否为新知识点或者知识点选项为空
		if(-1 == labelid){
			Label newLabel = new Label();
			newLabel.setLabelname(labeltext);
			newLabel.setBackup2(user.getId());
			labelid = bankLabelService.insertLabel(newLabel);
		}else if(-2 == labelid){
			
		}
		//	添加知识点，并创建新题返回题目id，因为创建选项需要题目id
		newQuestion.setLabelid(labelid);
		Integer questionId = questionService.insertSingleChoice(newQuestion);
		System.out.println("questionid:"+questionId);
		
		return "ok";
	}
	
	@RequestMapping("/bankShowQuestionPage")
	//进入题库初始页面
	public ModelAndView BankShowQuestionPage(HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("pages/bankShowQuestion");
		Integer bankId = Integer.parseInt(req.getParameter("thisId"));
		User myUser = (User)session.getAttribute("user");
		Bank bank = bankService.getBanKById(bankId);
		
		System.out.println("bankAddQuestionPage-bankId:"+bankId);
		System.out.println("myUser:"+myUser.getName());
		
//		现在获取了所有的题目
		ArrayList<Question> questionList = new ArrayList<Question>();
		ArrayList<Question> tempList = (ArrayList<Question>)questionService.getQuestionListByBankId(bankId);
		HashMap<Integer, Object> choiceMap = new HashMap<Integer, Object>();
		HashMap<Integer, Object> answerMap = new HashMap<Integer, Object>();
		ArrayList<Choice> choiceList;
		ArrayList<Integer> answerIdList;
		
		for(Question temp : tempList) {
			/*没有label的题目不需要labelname*/
			if(-2 == temp.getLabelid()) {
				
			}else {
				/*backup4在这时是用来存储知识点名称的*/
				String labelName = bankLabelService.getLabelById(temp.getLabelid());
				temp.setBackup4(labelName);
				System.out.println("labelName:"+labelName);
			}
			
			/*非简答题需要处理选项*/
			if(2 != temp.getTypeid()) {
				choiceList = (ArrayList<Choice>)bankChoiceService.getChoiceListByQuestionId(temp.getId());
				/*把一道题的所有选项放到一个list中，再以该题的id为键，把list存到choiceMap中*/
				choiceMap.put(temp.getId(), choiceList);
				
				String answerStr = temp.getAnswer();
				answerIdList = new ArrayList<Integer>();
				for(int i=0; i<answerStr.split("_").length; i++) {
					answerIdList.add(Integer.parseInt(answerStr.split("_")[i]));
				}
				/*把一道题的所有答案的id放到一个list中，再以该题的id为键，把list存到answerMap*/
				answerMap.put(temp.getId(), answerIdList);
			}
			questionList.add(temp);
		}
		
		session.setAttribute("bank", bank);
		mav.addObject("bank", bank);
		mav.addObject("questionList", questionList);
		mav.addObject("choiceMap", choiceMap);
		mav.addObject("answerMap", answerMap);
		System.out.println(mav.getModel());
		return mav;
	}
	
	@RequestMapping("/editQuestion")
	//进入题库初始页面
	public ModelAndView EditQuestion(HttpSession session, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("pages/bankEditQuestion");
		User myUser = (User)session.getAttribute("user");
		List<Label> labelList = bankLabelService.getLabelListByUserId(myUser.getId());
		
		Integer questionId = Integer.parseInt(req.getParameter("questionId"));
		Question question = questionService.getQuestionById(questionId);
		Integer bankId = question.getBankid();
		Bank bank = bankService.getBanKById(bankId);
		
		if(-2 == question.getLabelid()) {
			
		}else {
			/*backup4在这时是用来存储知识点名称的*/
			String labelName = bankLabelService.getLabelById(question.getLabelid());
			question.setBackup4(labelName);
			System.out.println("labelName:"+labelName);
		}
		
		// 判断是否为非简答题
		if(0 == question.getTypeid() || 1 == question.getTypeid()) {
			
			//无论单选还是多选，把答案选项的id加入answerList
			ArrayList<Integer> answerIdList = new ArrayList<Integer>();
			String[] ansStrs = question.getAnswer().split("_");
			for(String temp : ansStrs) {
				answerIdList.add(Integer.parseInt(temp));
			}
			
			//无论是单选还是多选,获得选择题的选项列表
			List<Choice> choiceList = bankChoiceService.getChoiceListByQuestionId(questionId);
			mav.addObject("answerIdList", answerIdList);
			mav.addObject("choiceList", choiceList);
		}
		
		mav.addObject("labelList", labelList);
		mav.addObject("question", question);
		session.setAttribute("bank", bank);
		session.setAttribute("question", question);
		mav.addObject("bank", bank);
		
		return mav;
	}

//	多选题、单选题的编辑都用此方法
	@RequestMapping("/editMutlipleQuestionByJson")
	@ResponseBody
	public String EditMutlipleQuestionByJson(HttpSession session, @RequestBody JSONObject params) {
		System.out.println("params:"+params);
		//  获取当前编辑的题
		Question oldQuestion = (Question)session.getAttribute("question");
		//	当前用户和当前题库	
		Bank bank = (Bank)session.getAttribute("bank");
		User user = (User)session.getAttribute("user");
		//	题型
		Integer typeid = params.getInteger("typeid");
		//	难度
		Integer difflevel = params.getInteger("difflevel");
		//	题目知识
		Integer labelid = params.getInteger("labelid");
		String labeltext = params.getString("labeltext");
		//  题干
		String description = params.getString("description");
		//	解析
		String analysis = params.getString("analysis");
		//	答案
		String answerStr = params.getString("answerArray");
		List<String> answerList = (List<String>)params.parse(answerStr);
		//	非答案选项
		String array = params.getString("nonAnswerArray");
		System.out.println("array:"+array);
		List<String> choiceList = (List<String>)params.parse(array);
		//现将现有的选项删除了
		int retVal = questionService.clearQuestionChoice(oldQuestion.getId());
		System.out.println("清除选项个数:"+retVal);
		
		//  创建新的题目		
		oldQuestion.setDescription(description);
		oldQuestion.setDifflevel(difflevel);
		oldQuestion.setAnalysis(analysis);
		//判断是否为新知识点或者知识点选项为空
		if(-1 == labelid){
			Label newLabel = new Label();
			newLabel.setLabelname(labeltext);
			newLabel.setBackup2(user.getId());
			labelid = bankLabelService.insertLabel(newLabel);
		}else if(-2 == labelid){
			
		}
		//	添加知识点，并创建新题返回题目id，因为创建选项需要题目id
		oldQuestion.setLabelid(labelid);
		Integer questionId = oldQuestion.getId();
		System.out.println("oldQuestion:"+questionId);
		//	处理答案和非答案选项部分
		Choice tempChoice;
		String answerString = "";
		//	答案部分
		for(String temp : answerList) {
			tempChoice = new Choice();
			tempChoice.setContent(temp);
			tempChoice.setQuestionid(questionId);
			Integer tempChoiceId = bankChoiceService.insertSingleChoice(tempChoice);
			System.out.println("tempAnswerChoiceId:"+tempChoiceId);
			answerString += tempChoiceId+"_";
		}
		System.out.println("answerString:"+answerString);
		//	将答案选项字符串传给新题
		oldQuestion.setAnswer(answerString);
		
		//	非答案选项	
		for(String temp : choiceList) {
			tempChoice = new Choice();
			tempChoice.setContent(temp);
			tempChoice.setQuestionid(questionId);
			Integer tempChoiceId = bankChoiceService.insertSingleChoice(tempChoice);
			System.out.println("tempChoiceId:"+tempChoiceId);
		}
		int retVal2 = questionService.updateQuestion(oldQuestion);
		System.out.println("更新选择题题目返回值："+retVal2);
		return "ok";
	}
	
//	简答题编辑都用此方法
	@RequestMapping("/editShortQuestionByJson")
	@ResponseBody
	public String EditShortQuestionByJson(HttpSession session, @RequestBody JSONObject params) {
		System.out.println("params:"+params);
		//  获取当前编辑的题
		Question oldQuestion = (Question)session.getAttribute("question");
		//	当前用户和当前题库	
		Bank bank = (Bank)session.getAttribute("bank");
		User user = (User)session.getAttribute("user");
		
		//	难度
		Integer difflevel = params.getInteger("difflevel");
		//	题目知识
		Integer labelid = params.getInteger("labelid");
		String labeltext = params.getString("labeltext");
		//  题干
		String description = params.getString("description");
		//	解析
		String analysis = params.getString("analysis");
		//	参考答案
		String referAnswer = params.getString("referAnswer");
		System.out.println("referAnswer:"+referAnswer);
		
		//  创建新的题目		
		oldQuestion.setDescription(description);
		oldQuestion.setDifflevel(difflevel);
		oldQuestion.setAnalysis(analysis);
		oldQuestion.setAnswer(referAnswer);
		//判断是否为新知识点或者知识点选项为空
		if(-1 == labelid){
			Label newLabel = new Label();
			newLabel.setLabelname(labeltext);
			newLabel.setBackup2(user.getId());
			labelid = bankLabelService.insertLabel(newLabel);
		}else if(-2 == labelid){
			
		}
		//	添加知识点，并创建新题返回题目id，因为创建选项需要题目id
		oldQuestion.setLabelid(labelid);
		int value = questionService.updateQuestion(oldQuestion);
		System.out.println("更新简答题目返回值："+value);
		
		return "ok";
	}
	
	@RequestMapping("/deleteAQuestion")
	@ResponseBody
	public String deleteAQuestion(HttpSession session,@RequestParam(value="questionId",required=true) Integer questionId) {
		System.out.println("删除题目:"+questionId);
		int value = questionService.deleteAQuestion(questionId);
		System.out.println("删除结果"+value);
		return "ok";
	}
}
