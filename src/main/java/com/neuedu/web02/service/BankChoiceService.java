package com.neuedu.web02.service;

import java.util.List;

import com.neuedu.web02.entity.Choice;

public interface BankChoiceService {
	int insertSingleChoice(Choice choice);
	
	List<Choice> getChoiceListByQuestionId(Integer questionId);
}
