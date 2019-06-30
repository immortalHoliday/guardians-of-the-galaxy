package com.neuedu.web02.dao;

import com.neuedu.web02.entity.BankTeacherMapping;
import com.neuedu.web02.entity.BankTeacherMappingExample;
import com.neuedu.web02.entity.BankTeacherMappingKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BankTeacherMappingMapper {
    int countByExample(BankTeacherMappingExample example);

    int deleteByExample(BankTeacherMappingExample example);

    int deleteByPrimaryKey(BankTeacherMappingKey key);

    int insert(BankTeacherMapping record);

    int insertSelective(BankTeacherMapping record);

    List<BankTeacherMapping> selectByExample(BankTeacherMappingExample example);

    BankTeacherMapping selectByPrimaryKey(BankTeacherMappingKey key);

    int updateByExampleSelective(@Param("record") BankTeacherMapping record, @Param("example") BankTeacherMappingExample example);

    int updateByExample(@Param("record") BankTeacherMapping record, @Param("example") BankTeacherMappingExample example);

    int updateByPrimaryKeySelective(BankTeacherMapping record);

    int updateByPrimaryKey(BankTeacherMapping record);
    
    List<BankTeacherMapping> selectShareFromList(@Param("userid") Integer id);
}