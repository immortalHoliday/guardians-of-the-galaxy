package com.neuedu.web02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.web02.dao.ChoiceMapper;
import com.neuedu.web02.entity.Choice;
import com.neuedu.web02.entity.ChoiceExample;
import com.neuedu.web02.entity.Label;
import com.neuedu.web02.entity.LabelExample;
import com.neuedu.web02.service.BankChoiceService;

@Service
public class BankChoiceServiceImpl implements BankChoiceService {
	
	@Autowired
	ChoiceMapper choiceMapper;

	@Override
	public int insertSingleChoice(Choice choice) {
		Integer val = choiceMapper.insertSelective(choice);
		Integer id = choice.getChoiceid();
		return id;
	}
	
	/*LabelExample labelExample = new LabelExample();
		LabelExample.Criteria labelCriteria = labelExample.createCriteria();
		labelCriteria.andBackup2EqualTo(userId);
		List<Label> labelList = labelMapper.selectByExample(labelExample);
		
		return labelList;*/

	@Override
	public List<Choice> getChoiceListByQuestionId(Integer questionId) {
		ChoiceExample choiceExample = new ChoiceExample();
		ChoiceExample.Criteria choiceCriteria = choiceExample.createCriteria();
		choiceCriteria.andQuestionidEqualTo(questionId);
		List<Choice> choiceList = choiceMapper.selectByExample(choiceExample);
		return choiceList;
	}

}
