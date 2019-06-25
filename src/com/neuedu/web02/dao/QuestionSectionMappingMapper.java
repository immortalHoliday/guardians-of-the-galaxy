package com.neuedu.web02.dao;

import com.neuedu.web02.entity.QuestionSectionMapping;
import com.neuedu.web02.entity.QuestionSectionMappingExample;
import com.neuedu.web02.entity.QuestionSectionMappingKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionSectionMappingMapper {
    int countByExample(QuestionSectionMappingExample example);

    int deleteByExample(QuestionSectionMappingExample example);

    int deleteByPrimaryKey(QuestionSectionMappingKey key);

    int insert(QuestionSectionMapping record);

    int insertSelective(QuestionSectionMapping record);

    List<QuestionSectionMapping> selectByExample(QuestionSectionMappingExample example);

    QuestionSectionMapping selectByPrimaryKey(QuestionSectionMappingKey key);

    int updateByExampleSelective(@Param("record") QuestionSectionMapping record, @Param("example") QuestionSectionMappingExample example);

    int updateByExample(@Param("record") QuestionSectionMapping record, @Param("example") QuestionSectionMappingExample example);

    int updateByPrimaryKeySelective(QuestionSectionMapping record);

    int updateByPrimaryKey(QuestionSectionMapping record);
}