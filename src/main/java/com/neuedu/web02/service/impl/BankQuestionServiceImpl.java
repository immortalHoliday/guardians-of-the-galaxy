package com.neuedu.web02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.web02.dao.ChoiceMapper;
import com.neuedu.web02.dao.LabelMapper;
import com.neuedu.web02.dao.QuestionMapper;
import com.neuedu.web02.dao.TypeMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankExample;
import com.neuedu.web02.entity.ChoiceExample;
import com.neuedu.web02.entity.Question;
import com.neuedu.web02.entity.QuestionExample;
import com.neuedu.web02.service.BankQuestionService;



@Service
public class BankQuestionServiceImpl implements BankQuestionService {
	
	@Autowired
	QuestionMapper questionMapper;
	@Autowired
	LabelMapper labelMapper;
	@Autowired
	ChoiceMapper choiceMapper;
	@Autowired
	TypeMapper typeMapper;

	@Override
	public int insertSingleChoice(Question question) {
		Integer val = questionMapper.insertSelective(question);
		Integer id = question.getId();
		return id;
	}

	@Override
	public int updateAnswerChoice(Question question) {
		Question tempQuestion = new Question();
		tempQuestion.setId(question.getId());
		tempQuestion.setAnswer(question.getAnswer());
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andIdEqualTo(tempQuestion.getId());
		int value = questionMapper.updateByExampleSelective(tempQuestion, questionExample);
		return value;
	}

	@Override
	public List<Question> getQuestionListByBankId(Integer bankId) {
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andBankidEqualTo(bankId);
		List<Question> questionList = questionMapper.selectByExample(questionExample);
		return questionList;
	}

	@Override
	public Question getQuestionById(Integer questionId) {
		Question question = questionMapper.selectByPrimaryKey(questionId);
		return question;
	}

	@Override
	public int clearQuestionChoice(Integer questionId) {
		ChoiceExample choiceExample = new ChoiceExample();
		ChoiceExample.Criteria criteria = choiceExample.createCriteria();
		criteria.andQuestionidEqualTo(questionId);
		int value = choiceMapper.deleteByExample(choiceExample);
		return value;
	}

	@Override
	public int updateQuestion(Question question) {
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andIdEqualTo(question.getId());
		int value = questionMapper.updateByExampleSelective(question, questionExample);
	
		return value;
	}

	@Override
	public int deleteAQuestion(Integer questionId) {
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andIdEqualTo(questionId);
		int value1 = 0;
		Question question = questionMapper.selectByPrimaryKey(questionId);
		if(2 != question.getTypeid()) {
			ChoiceExample choiceExample = new ChoiceExample();
			ChoiceExample.Criteria choiceCriteria = choiceExample.createCriteria();
			choiceCriteria.andQuestionidEqualTo(questionId);
			value1 = choiceMapper.deleteByExample(choiceExample);
		}
		int value2 = questionMapper.deleteByExample(questionExample);
		
		
		return value1+value2;
	}

}
