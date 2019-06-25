package com.neuedu.web02.dao;

import com.neuedu.web02.entity.UserAnswer;
import com.neuedu.web02.entity.UserAnswerExample;
import com.neuedu.web02.entity.UserAnswerKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAnswerMapper {
    int countByExample(UserAnswerExample example);

    int deleteByExample(UserAnswerExample example);

    int deleteByPrimaryKey(UserAnswerKey key);

    int insert(UserAnswer record);

    int insertSelective(UserAnswer record);

    List<UserAnswer> selectByExample(UserAnswerExample example);

    UserAnswer selectByPrimaryKey(UserAnswerKey key);

    int updateByExampleSelective(@Param("record") UserAnswer record, @Param("example") UserAnswerExample example);

    int updateByExample(@Param("record") UserAnswer record, @Param("example") UserAnswerExample example);

    int updateByPrimaryKeySelective(UserAnswer record);

    int updateByPrimaryKey(UserAnswer record);
}