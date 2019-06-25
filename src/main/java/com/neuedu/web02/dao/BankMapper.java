package com.neuedu.web02.dao;

import com.neuedu.web02.entity.Bank;
import com.neuedu.web02.entity.BankExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BankMapper {
    int countByExample(BankExample example);

    int deleteByExample(BankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bank record);

//    此insert方法可以返回插入元素的主键，通过在创建元素后，调用.getId()获得主键
    int insertSelective(Bank record);

    List<Bank> selectByExample(BankExample example);

    Bank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByExample(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
    
    //获得最新插入的题库的id
    int selectNewBankId();
    
    //输入一个老师的id，获得由该老师创建所有不在回收站的题库(暂时还没有实现不在归档处的文件时)
    List<Bank> selectUseableBankByCreaterId(@Param("cid") Integer id);
    
    //输入一个老师的id，获得由该老师创建的所有在回收站的题库
    List<Bank> selectBankInRecycleByCreaterId(@Param("cid") Integer id);
    
    //将一个用户的回收站清空
    int deleteBankAndBankTeacherMappingByUserId(@Param("cid") Integer id);
    
    //将一个用户的所有题库恢复
    int recoverBankAllByUserId(@Param("cid") Integer id);
}