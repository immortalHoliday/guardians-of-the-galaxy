package com.neuedu.web02.dao;

import com.neuedu.web02.entity.Judgequestion;
import com.neuedu.web02.entity.JudgequestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JudgequestionMapper {
    int countByExample(JudgequestionExample example);

    int deleteByExample(JudgequestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Judgequestion record);

    int insertSelective(Judgequestion record);

    List<Judgequestion> selectByExample(JudgequestionExample example);

    Judgequestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Judgequestion record, @Param("example") JudgequestionExample example);

    int updateByExample(@Param("record") Judgequestion record, @Param("example") JudgequestionExample example);

    int updateByPrimaryKeySelective(Judgequestion record);

    int updateByPrimaryKey(Judgequestion record);
}