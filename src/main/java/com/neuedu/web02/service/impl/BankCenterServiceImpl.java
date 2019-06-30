package com.neuedu.web02.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.web02.dao.BankMapper;
import com.neuedu.web02.dao.BankTeacherMappingMapper;
import com.neuedu.web02.dao.ChoiceMapper;
import com.neuedu.web02.dao.QuestionMapper;
import com.neuedu.web02.dao.UserMapper;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankExample;
import com.neuedu.web02.entity.BankTeacherMapping;
import com.neuedu.web02.entity.BankTeacherMappingExample;
import com.neuedu.web02.entity.BankTeacherMappingKey;
import com.neuedu.web02.entity.ChoiceExample;
import com.neuedu.web02.entity.Question;
import com.neuedu.web02.entity.QuestionExample;
import com.neuedu.web02.service.BankCenterService;

@Service
public class BankCenterServiceImpl implements BankCenterService {
	
	@Autowired
	BankMapper bankMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	BankTeacherMappingMapper bankTeacherMappingMapper;
	@Autowired
	QuestionMapper questionMapper;
	@Autowired
	ChoiceMapper choiceMapper;
	
	@Override
	public Bank insertBank(Bank bank) {
		int value = bankMapper.insertSelective(bank);
		Bank newBank = bankMapper.selectByPrimaryKey(bank.getId());
		return newBank;
	}
	
	@Override
	public ArrayList<Bank> getAllBank(Integer userId){
		/*所有由该用户创建的题库*/
		ArrayList<Bank> list = (ArrayList)bankMapper.selectUseableBankByCreaterId(userId);
		return list;
	}

	@Override
	public int bankIntoRecycle(Integer bankId) {
		Bank record = new Bank();
		BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bankId);
		record.setDeleteflag(1);
		int value = bankMapper.updateByExampleSelective(record, bankExample);
		return value;
	}

	@Override
	public int editBank(Bank bank) {
		BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bank.getId());
		int value = bankMapper.updateByExampleSelective(bank, bankExample);
		return value;
	}

	@Override
	public Bank getBanKById(Integer id) {
		Bank bank = bankMapper.selectByPrimaryKey(id);
		return bank;
	}

	@Override
	public ArrayList<Bank> getRecycleList(Integer userId) {
		ArrayList<Bank> list = (ArrayList)bankMapper.selectBankInRecycleByCreaterId(userId);
		return list;
	}

	@Override
	public int insertIntoBankTeacherMapping(Integer userId, Integer bankId) {
		int value = bankTeacherMappingMapper.insertSelective(new BankTeacherMapping(bankId, userId));
		return value;
	}

	@Override
	public int destoryBankByBankId(Integer bankId) {
		/*先获取该题库所有的题目*/
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria questionCriteria = questionExample.createCriteria(); 
		questionCriteria.andBankidEqualTo(bankId);
		List<Question> questionList = questionMapper.selectByExample(questionExample);
		
		Integer questionId,value=0;
		
		/*若是选择题删除该题目下的所有选项*/
		for(Question tempQ : questionList) {
			if(0 == tempQ.getTypeid() || 1 == tempQ.getTypeid()) {
				questionId = tempQ.getId();
				ChoiceExample choiceExample = new ChoiceExample();
				ChoiceExample.Criteria choiceCriteria = choiceExample.createCriteria(); 
				choiceCriteria.andQuestionidEqualTo(questionId);
				value += choiceMapper.deleteByExample(choiceExample);
			}
		}
		
		/*再删除题目*/
		questionExample = new QuestionExample();
		questionCriteria = questionExample.createCriteria(); 
		questionCriteria.andBankidEqualTo(bankId);
		value += questionMapper.deleteByExample(questionExample);
		
		/*再删除题库*/
		value += bankMapper.deleteByPrimaryKey(bankId);
		
		/*删除题库-教师映射表*/
		BankTeacherMappingExample example = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = example.createCriteria();
		    /*note：这种删法把所有分享的题库也删除了*/
		criteria.andBankidEqualTo(bankId);
		value += bankTeacherMappingMapper.deleteByExample(example);
		
		if(0 == value) {
			return -1;
		}else {
			return 1;
		}
	}

	@Override
	public int recoverBankByBankId(Integer bankId) {
		Bank bank = new Bank();
		bank.setDeleteflag(0);
		
		BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bankId);
		int value = bankMapper.updateByExampleSelective(bank, bankExample);
		return value;
	}

	@Override
	@Deprecated
	public int clearRecycleByUserId(Integer userId) {
		/*先获取所有题库的id*/
		List<Bank> bankList = this.getRecycleList(userId);
		List<Integer> bankIdList = new ArrayList<Integer>();
		for(Bank tempBank : bankList) {
			bankIdList.add(tempBank.getId());
		}
		/*调用本类中的destoryBankByBankId逐个删除题库*/
		int value=0;
		for(Integer tempId : bankIdList) {
			value += this.destoryBankByBankId(tempId);
		}
		return value;
	}

	@Override
	public int recoverBankAllByUserId(Integer userId) {
		int value = bankMapper.recoverBankAllByUserId(userId);
		System.out.println("recoverBankAllByUserId value:"+value);
		return value;
	}

	@Override
	public Integer getQuestionCountByBankId(Integer bankId) {
		QuestionExample questionExample = new QuestionExample();
		QuestionExample.Criteria criteria = questionExample.createCriteria();
		criteria.andBankidEqualTo(bankId);
		List<Question> list = questionMapper.selectByExample(questionExample);
		return list.size();
	}

	@Override
	public Integer shareABank(Integer bankId, Integer userId, String autStr) {
		
		BankTeacherMapping bankTeacherMapping =  new BankTeacherMapping();
		bankTeacherMapping.setBankid(bankId);
		bankTeacherMapping.setTeacherid(userId);
		bankTeacherMapping.setState(3);
		bankTeacherMapping.setBackup1(autStr);
		Integer value = bankTeacherMappingMapper.insertSelective(bankTeacherMapping);
		return value;
	}

	@Override
	public ArrayList<BankTeacherMapping> getShareList(Integer userId) {
		BankTeacherMappingExample example = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(userId);
		criteria.andStateBetween(2, 3);
		ArrayList<BankTeacherMapping> list = (ArrayList<BankTeacherMapping>)bankTeacherMappingMapper.selectByExample(example);
		for(BankTeacherMapping temp : list) {
			System.out.println("getShareList-to:"+temp.getTeacherid());
		}
		return list;
	}
	
	@Override
	public PageInfo<BankTeacherMapping> getShareListPage(Integer pageNum, Integer pageSize, Integer userId) {
		Object obj = PageHelper.startPage(pageNum, pageSize);
		BankTeacherMappingExample example = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(userId);
		criteria.andStateBetween(2, 3);
		List<BankTeacherMapping> list = bankTeacherMappingMapper.selectByExample(example);
		for(BankTeacherMapping temp : list) {
			System.out.println("getShareList-to-page:"+temp.getTeacherid());
		}
		
		//用PageInfo对结果进行包装
        PageInfo<BankTeacherMapping> page = new PageInfo<BankTeacherMapping>(list);
		return page;
	}

	@Override
	public ArrayList<BankTeacherMapping> getShareFromMeList(Integer userId) {
		ArrayList<BankTeacherMapping> bankTeacherMappingList = (ArrayList<BankTeacherMapping>)bankTeacherMappingMapper.selectShareFromList(userId);
		for(BankTeacherMapping temp : bankTeacherMappingList) {
			System.out.println("getShareFromMeList-to:"+temp.getTeacherid());
		}
		return bankTeacherMappingList;
	}
	
	@Override
	public PageInfo<BankTeacherMapping> getShareFromMeListPage(Integer pageNum, Integer pageSize, Integer userId) {
		Object obj = PageHelper.startPage(pageNum, pageSize);
		ArrayList<BankTeacherMapping> bankTeacherMappingList = (ArrayList<BankTeacherMapping>)bankTeacherMappingMapper.selectShareFromList(userId);
		//用PageInfo对结果进行包装
        PageInfo<BankTeacherMapping> page = new PageInfo<BankTeacherMapping>(bankTeacherMappingList);
		return page;
	}

	@Override
	public int updateBankTeacherMappingState(Integer bankId, Integer teacherId, Integer state) {
		BankTeacherMapping bankTeacherMapping = new BankTeacherMapping();
		bankTeacherMapping.setState(state);
		
		BankTeacherMappingExample example = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = example.createCriteria();
		criteria.andBankidEqualTo(bankId);
		criteria.andTeacheridEqualTo(teacherId);
		
		int value = bankTeacherMappingMapper.updateByExampleSelective(bankTeacherMapping, example);
		return value;
	}

	@Override
	public BankTeacherMapping findBTMByPrimaryKey(Integer bankId, Integer userId) {
		BankTeacherMapping btm = bankTeacherMappingMapper.selectByPrimaryKey(new BankTeacherMappingKey(bankId, userId));
		return btm;
	}

	@Override
	public int updateAutByBankIdAndTeaId(Integer bankId, Integer teacherId, String aut) {
		BankTeacherMappingExample bankTeacherMapperExample = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = bankTeacherMapperExample.createCriteria();
		criteria.andBankidEqualTo(bankId);
		criteria.andTeacheridEqualTo(teacherId);
		BankTeacherMapping btm = new BankTeacherMapping();
		btm.setBackup1(aut);
		int value = bankTeacherMappingMapper.updateByExampleSelective(btm, bankTeacherMapperExample);
		return value;
	}

	@Override
	public int deleteBankTeacherMappingByBankIdAndTeaId(Integer bankId, Integer teacherId) {
		BankTeacherMappingExample bankTeacherMapperExample = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = bankTeacherMapperExample.createCriteria();
		criteria.andBankidEqualTo(bankId);
		criteria.andTeacheridEqualTo(teacherId);
		int value = bankTeacherMappingMapper.deleteByExample(bankTeacherMapperExample);
		return value;
	}

	@Override
	public int bankArchive(Integer bankId) {
		Bank record = new Bank();
		BankExample bankExample = new BankExample();
		BankExample.Criteria criteria = bankExample.createCriteria();
		criteria.andIdEqualTo(bankId);
		record.setDeleteflag(2);
		int value = bankMapper.updateByExampleSelective(record, bankExample);
		
		return value;
	}

	@Override
	public ArrayList<Bank> getArchiveList(Integer userId) {
		List<BankTeacherMapping> mappingList;
		BankTeacherMappingExample bankTeacherMapperExample = new BankTeacherMappingExample();
		BankTeacherMappingExample.Criteria criteria = bankTeacherMapperExample.createCriteria();
		criteria.andTeacheridEqualTo(userId);
		/*获取到我所有的题库*/
		mappingList = bankTeacherMappingMapper.selectByExample(bankTeacherMapperExample);
		/*用来存储归档题库的列表*/
		ArrayList<Bank> bankList = new ArrayList<Bank>();
		Bank bank;
		
		/*获取我的题库中所有的归档题库*/
		for(BankTeacherMapping temp : mappingList) {
			bank = bankMapper.selectByPrimaryKey(temp.getBankid());
			if(2 == bank.getDeleteflag()) {
				bankList.add(bank);
			}
		}
		
		return bankList;
	}

	
}
