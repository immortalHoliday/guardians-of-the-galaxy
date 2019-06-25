package com.neuedu.web02.dao;

import com.neuedu.web02.entity.Choice;
import com.neuedu.web02.entity.ChoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ChoiceMapper {
    int countByExample(ChoiceExample example);

    int deleteByExample(ChoiceExample example);

    int deleteByPrimaryKey(Integer choiceid);

    int insert(Choice record);

    int insertSelective(Choice record);

    List<Choice> selectByExample(ChoiceExample example);

    Choice selectByPrimaryKey(Integer choiceid);

    int updateByExampleSelective(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByExample(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByPrimaryKeySelective(Choice record);

    int updateByPrimaryKey(Choice record);
}