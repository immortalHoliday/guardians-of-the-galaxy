package com.neuedu.web02.dao;

import com.neuedu.web02.entity.AnswerQuestion;
import com.neuedu.web02.entity.AnswerQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswerQuestionMapper {
    int countByExample(AnswerQuestionExample example);

    int deleteByExample(AnswerQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AnswerQuestion record);

    int insertSelective(AnswerQuestion record);

    List<AnswerQuestion> selectByExample(AnswerQuestionExample example);

    AnswerQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AnswerQuestion record, @Param("example") AnswerQuestionExample example);

    int updateByExample(@Param("record") AnswerQuestion record, @Param("example") AnswerQuestionExample example);

    int updateByPrimaryKeySelective(AnswerQuestion record);

    int updateByPrimaryKey(AnswerQuestion record);
}