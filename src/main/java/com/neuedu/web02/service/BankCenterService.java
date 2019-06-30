package com.neuedu.web02.service;

import java.util.ArrayList;

import com.github.pagehelper.PageInfo;
import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankTeacherMapping;

public interface BankCenterService {
	Bank insertBank(Bank band);
	
	ArrayList<Bank> getAllBank(Integer userId);
	
	int bankIntoRecycle(Integer bankId);
	
	int bankArchive(Integer bankId);
	
	int editBank(Bank bank);
	
	Bank getBanKById(Integer id);
	
	ArrayList<Bank> getRecycleList(Integer userId);
	
	int insertIntoBankTeacherMapping(Integer userId, Integer bankId);
	
	int destoryBankByBankId(Integer bankId);
	
	int recoverBankByBankId(Integer bankId);
	
	int clearRecycleByUserId(Integer userId);
	
	int recoverBankAllByUserId(Integer userId);
	
	Integer getQuestionCountByBankId(Integer bankId);
	
	Integer shareABank(Integer bankId, Integer userId, String autStr);
	
	/*获取分享给我的列表 */
	ArrayList<BankTeacherMapping> getShareList(Integer userId);
	
	PageInfo<BankTeacherMapping> getShareListPage(Integer pageNum, Integer pageSize, Integer userId);
	
	/*获取我分享的列表*/
	ArrayList<BankTeacherMapping> getShareFromMeList(Integer userId);
	
	PageInfo<BankTeacherMapping> getShareFromMeListPage(Integer pageNum, Integer pageSize, Integer userId);
	
	int updateBankTeacherMappingState(Integer bankId, Integer teacherId, Integer state);
	
	BankTeacherMapping findBTMByPrimaryKey(Integer bankId, Integer userId);
	
	int updateAutByBankIdAndTeaId(Integer bankId, Integer teacherId, String aut);
	
	int deleteBankTeacherMappingByBankIdAndTeaId(Integer bankId, Integer teacherId);
	
	ArrayList<Bank> getArchiveList(Integer userId);
}
