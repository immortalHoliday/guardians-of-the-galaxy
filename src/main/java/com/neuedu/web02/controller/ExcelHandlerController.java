package com.neuedu.web02.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankTeacherMapping;
import com.neuedu.web02.entity.Choice;
import com.neuedu.web02.entity.Label;
import com.neuedu.web02.entity.Question;
import com.neuedu.web02.entity.User;
import com.neuedu.web02.service.BankCenterService;
import com.neuedu.web02.service.BankChoiceService;
import com.neuedu.web02.service.BankLabelService;
import com.neuedu.web02.service.BankQuestionService;
import com.neuedu.web02.service.BankUserService;
import com.neuedu.web02.util.excel.ExcelException;
import com.neuedu.web02.util.excel.ExcelUtil;
import com.neuedu.web02.util.excel.ShortQuestionDTO;

@Controller
public class ExcelHandlerController {
	
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
	
	/**
     * 导出 Excel（一个 sheet）
     */
    @RequestMapping("/exportexcel")
    public void test3( HttpServletResponse response) throws IOException, ExcelException {
    	List<ShortQuestionDTO> list = getExample();//模拟从数据库中得到一个数据集合
        String fileName = "excel导入题目模板（导入时请删除第一行提示行）";
        String sheetName = "示例页";

        ExcelUtil.writeExcel(response, list, fileName, sheetName, new ShortQuestionDTO());
    }
    
    
    @RequestMapping("/importexcel")
    public ModelAndView test2(HttpSession session, @RequestParam("file") MultipartFile file,HttpServletRequest request) {
    	
    	System.out.println("in importexcel");
        Integer thisBankId = Integer.parseInt(request.getParameter("thisBankId"));
        Bank theBank = bankService.getBanKById(thisBankId);
        User user = (User)session.getAttribute("user");
        System.out.println("要把excel中的数据加入题库:"+thisBankId);
        
		List<Object> resultlist = ExcelUtil.readExcel(file, new ShortQuestionDTO());
		ShortQuestionDTO dto;
		for (Object o : resultlist) {
			System.out.println(o.toString());
		}
		
		
		// TODO 以上是获取了excel中传来的文件中的数据，要开始把数据存入数据库
		for(Object temp : resultlist) {
			dto = (ShortQuestionDTO)temp;
			
			if(dto.getTypeId().equals("1") || dto.getTypeId().equals("0")) {
				System.out.println("我是选择题:"+dto.toString());
				Question question = new Question();
				//加入题目类型typeid
				question.setTypeid(Integer.parseInt(dto.getTypeId()));
				//处理题目难度difflevel
				Integer diffLevel = Integer.parseInt(dto.getDiffLevel());
				if(1 == diffLevel) {
					question.setDifflevel(1);
				}else if(2 == diffLevel) {
					question.setDifflevel(2);
				}else {
					//默认和易 都是0
					question.setDifflevel(0);
				}
				//处理知识点label
				String labelContent = dto.getLabel();
				Integer labelId=-1;
				Label label;
				if(null == labelContent) {
					//没有知识点，置为-2
					labelId = -2;
					System.out.println("没有知识点 啊偶");
				}else {
					label = bankLabelService.checkExistByContentAndUserId(labelContent, user.getId());
				
					if(null == label) {
						//是不存在的新知识点
						//新建一个知识点
						label = new Label();
						label.setBackup2(user.getId());
						label.setLabelname(labelContent);
						labelId = bankLabelService.insertLabel(label);
						System.out.println("知识点是新知识点 啊哈");
					}else {
						//是已存在的知识点，调用即可
						labelId = label.getLabelid();
						System.out.println("知识点已经存在了 啊偶");
					}
				}
				question.setLabelid(labelId);
				//处理题库id
				question.setBankid(theBank.getId());
				//处理题干
				question.setDescription(dto.getDescription());
				//处理题目解析
				question.setAnalysis(dto.getAnalysis());
				//创建新题目
				Integer questionId = questionService.insertSingleChoice(question);
				//处理答案和非答案选项部分
				String[] answerStrList, nonAnwerStrList;
				String answerStr=new String();
				
				answerStrList = dto.getanswerChoices().split("_");
				nonAnwerStrList = dto.getnonAnswerChoices().split("_");
				for(String tempAnswer : answerStrList) {
					Choice answerChoice = new Choice();
					answerChoice.setContent(tempAnswer);
					answerChoice.setQuestionid(questionId);
					Integer answerChoiceId = bankChoiceService.insertSingleChoice(answerChoice);
					answerStr += answerChoiceId+"_";
				}
				System.out.println("答案选项字符串是-answerStr:"+answerStr);
				question.setAnswer(answerStr);
				Integer value = questionService.updateAnswerChoice(question);
				//处理非答案选项
				for(String tempNonAnswer : nonAnwerStrList) {
					Choice nonAnswerChoice = new Choice();
					nonAnswerChoice.setContent(tempNonAnswer);
					nonAnswerChoice.setQuestionid(questionId);
					Integer tempChoiceId = bankChoiceService.insertSingleChoice(nonAnswerChoice);
				}
				//创建选择题结束
				System.out.println("通过excel导入的选择题:"+questionId);
			}else if(dto.getTypeId().equals("2")) {
				
				System.out.println("我是简答题:"+dto.toString());
				Question question = new Question();
				//加入题目类型typeid
				question.setTypeid(Integer.parseInt(dto.getTypeId()));
				//处理题目难度difflevel
				Integer diffLevel = Integer.parseInt(dto.getDiffLevel());
				if(1 == diffLevel) {
					question.setDifflevel(1);
				}else if(2 == diffLevel) {
					question.setDifflevel(2);
				}else {
					//默认和易 都是0
					question.setDifflevel(0);
				}
				//处理知识点label
				String labelContent = dto.getLabel();
				System.out.println("dto.getLabel:"+labelContent);
				Integer labelId=-1;
				Label label;
				if(null == labelContent) {
					//没有知识点，置为-2
					labelId = -2;
				}else {
					label = bankLabelService.checkExistByContentAndUserId(labelContent, user.getId());
				
					if(null == label) {
						//是不存在的新知识点
						//新建一个知识点
						label = new Label();
						label.setBackup2(user.getId());
						label.setLabelname(labelContent);
						labelId = bankLabelService.insertLabel(label);
					}else {
						//是已存在的知识点，调用即可
						labelId = label.getLabelid();
					}
				}
				question.setLabelid(labelId);
				//处理题干
				question.setDescription(dto.getDescription());
				//处理参考答案
				question.setAnswer(dto.getAnswer());
				//处理题目解析
				question.setAnalysis(dto.getAnalysis());
				//处理题库id
				question.setBankid(theBank.getId());
				
				Integer questionId = questionService.insertSingleChoice(question);
				System.out.println("通过excel导入的简答题:"+questionId);
			}
		}
		
		
		// TODO 一下是为了跳转页面的操作，
		
		ModelAndView mav = new ModelAndView("pages/mybankhomepage");
		
		/*该用户所有的题库，包括自创题库，收到的分享且已确认的题库，购买的题库还没有加入*/
		ArrayList<Bank> list = bankService.getAllBank(user.getId());
//		System.out.println("查到的题库数量:"+list.size());
		/*获取所有被分享的题库的映射类，包括未确认的和确认的*/
		ArrayList<BankTeacherMapping> mappingList = bankService.getShareList(user.getId());
//		System.out.println("题库中分享来的数量:"+mappingList.size());
		/*把自己可以用的分享来的题库和题库创建者的name关联起来*/
		HashMap<Integer, String> bankTeacherMap = new HashMap<Integer, String>();
		/*autMap 把一个题库与对应的权限对应，键为bankid_autid-> 15_2 -> 题库15的2（修改权限）权限，value为1有权限0无权限*/
		HashMap<String, Integer> autMap = new HashMap<String, Integer>();
		
		String autString;
		String autStringArray[];
		Integer count=1;
		
		/*对于每个分享来的题库，把创建人和题库权限加入*/
		for(BankTeacherMapping temp : mappingList) {
			User tempUser = userService.findUserByBankId(temp.getBankid());
			bankTeacherMap.put(temp.getBankid(), tempUser.getName());
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
    
    private List<ShortQuestionDTO> getExample() {
    	List<ShortQuestionDTO> list = new ArrayList<>();
    	ShortQuestionDTO model = new ShortQuestionDTO();
        model.setTypeId("添加数字 0单选题 1多选题 2简答题");
        model.setDiffLevel("添加数字（默认为0）0易 1中 2难");
        model.setLabel("添加知识点 如:等比数列");
        model.setDescription("添加题干");
        model.setnonAnswerChoices("添加选择题*非正确答案*选项 以双下滑线分割 如:xxx__yyy__");
        model.setAnswer("添加参考答案（选择题不用添加）");
        model.setAnalysis("添加题目解析");
        model.setanswerChoices("添加选择题*正确答案*选项 以双下滑线分割 如:xxx__yyy__");
        list.add(model);

        return list;
    }

}
