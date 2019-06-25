package com.neuedu.web02.dao;

import com.neuedu.web02.entity.UserExamRecord;
import com.neuedu.web02.entity.UserExamRecordExample;
import com.neuedu.web02.entity.UserExamRecordKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserExamRecordMapper {
    int countByExample(UserExamRecordExample example);

    int deleteByExample(UserExamRecordExample example);

    int deleteByPrimaryKey(UserExamRecordKey key);

    int insert(UserExamRecord record);

    int insertSelective(UserExamRecord record);

    List<UserExamRecord> selectByExample(UserExamRecordExample example);

    UserExamRecord selectByPrimaryKey(UserExamRecordKey key);

    int updateByExampleSelective(@Param("record") UserExamRecord record, @Param("example") UserExamRecordExample example);

    int updateByExample(@Param("record") UserExamRecord record, @Param("example") UserExamRecordExample example);

    int updateByPrimaryKeySelective(UserExamRecord record);

    int updateByPrimaryKey(UserExamRecord record);
}