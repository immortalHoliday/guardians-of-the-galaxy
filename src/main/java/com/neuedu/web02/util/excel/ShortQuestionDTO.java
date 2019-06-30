package com.neuedu.web02.util.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ShortQuestionDTO extends BaseRowModel {

	/** 题型 **/
    @ExcelProperty(index = 0 , value = "题型*")
    private String typeId;
    
    /** 邮箱 **/
    @ExcelProperty(index = 1 , value = "难度*")
    private String diffLevel;
    
    /** 知识点 **/
    @ExcelProperty(index = 2 , value = "知识点")
    private String label;
    
    /** 题干 **/
    @ExcelProperty(index = 3 , value = "题干*")
    private String description;
    
    /** 答案 **/
    @ExcelProperty(index = 4 , value = "参考答案")
    private String answer;
    
    /** 非答案选项 **/
    @ExcelProperty(index = 5 , value = "选择题非正确答案选项")
    private String nonAnswerChoices;
    

    
    /** 答案选项 **/
    @ExcelProperty(index = 7 , value = "选择题正确答案选项")
    private String answerChoices;
    
    /** 题目解析 **/
    @ExcelProperty(index = 6 , value = "题目解析")
    private String analysis;
    
    

	@Override
	public String toString() {
		return "ShortQuestionDTO [typeId=" + typeId + ", diffLevel=" + diffLevel + ", label=" + label + ", description="
				+ description + ", answer=" + answer + ", nonAnswerChoices=" + nonAnswerChoices + ", analysis="
				+ analysis + ", answerChoices=" + answerChoices + "]";
	}

	public ShortQuestionDTO() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ShortQuestionDTO(String typeId, String diffLevel, String label, String description, String answer,
			String nonAnswerChoices, String analysis, String answerChoices) {
		super();
		this.typeId = typeId;
		this.diffLevel = diffLevel;
		this.label = label;
		this.description = description;
		this.answer = answer;
		this.nonAnswerChoices = nonAnswerChoices;
		this.analysis = analysis;
		this.answerChoices = answerChoices;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getDiffLevel() {
		return diffLevel;
	}

	public void setDiffLevel(String diffLevel) {
		this.diffLevel = diffLevel;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getnonAnswerChoices() {
		return nonAnswerChoices;
	}

	public void setnonAnswerChoices(String nonAnswerChoices) {
		this.nonAnswerChoices = nonAnswerChoices;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getanswerChoices() {
		return answerChoices;
	}

	public void setanswerChoices(String answerChoices) {
		this.answerChoices = answerChoices;
	}
    
    
}
