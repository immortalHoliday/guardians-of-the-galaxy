package com.neuedu.web02.service;

import java.util.List;

import com.neuedu.web02.entity.Label;

public interface BankLabelService {

	int insertLabel(Label label);
	
	List<Label> getLabelListByUserId(Integer userId);
	
	String getLabelById(Integer labelId);
}
