package com.neuedu.web02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.web02.dao.LabelMapper;
import com.neuedu.web02.entity.BankExample;
import com.neuedu.web02.entity.Label;
import com.neuedu.web02.entity.LabelExample;

@Service
public class BankLabelServiceImpl implements com.neuedu.web02.service.BankLabelService {
	
	@Autowired
	LabelMapper labelMapper;

	@Override
	public int insertLabel(Label label) {
		Integer val = labelMapper.insertSelective(label);
		Integer id = label.getLabelid();
		return id;
	}

	@Override
	public List<Label> getLabelListByUserId(Integer userId) {
		LabelExample labelExample = new LabelExample();
		LabelExample.Criteria labelCriteria = labelExample.createCriteria();
		labelCriteria.andBackup2EqualTo(userId);
		List<Label> labelList = labelMapper.selectByExample(labelExample);
		
		return labelList;
	}


	@Override
	public String getLabelById(Integer labelId) {
		Label label = labelMapper.selectByPrimaryKey(labelId);
		
		return label.getLabelname();
	}

	@Override
	public Label checkExistByContentAndUserId(String content, Integer userId) {
		LabelExample labelExample = new LabelExample();
		LabelExample.Criteria labelCriteria = labelExample.createCriteria();
		labelCriteria.andBackup2EqualTo(userId);
		labelCriteria.andLabelnameEqualTo(content);
		List<Label> list = labelMapper.selectByExample(labelExample);
		if(null == list || 0 == list.size()) {
			return null;
		}else {
			return list.get(0);
		}	
	}
	
}
