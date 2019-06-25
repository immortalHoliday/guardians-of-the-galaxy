package com.neuedu.web02.service;

import java.util.List;

import com.neuedu.web02.entity.Question;

public interface BankQuestionService {
	int insertSingleChoice(Question question);
	
	int updateAnswerChoice(Question question);
	
	List<Question> getQuestionListByBankId(Integer bankId);
	
	Question getQuestionById(Integer questionId);
	
	int clearQuestionChoice(Integer questionId);
	
	int updateQuestion(Question question);
	
	int deleteAQuestion(Integer questionId);
}
