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

	
/*BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bank.getId());
		int value = bankMapper.updateByExampleSelective(bank, bankExample);
		return value;*/
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
	
}
