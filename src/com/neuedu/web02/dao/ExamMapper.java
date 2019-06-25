package com.neuedu.web02.dao;

import com.neuedu.web02.entity.Exam;
import com.neuedu.web02.entity.ExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamMapper {
    int countByExample(ExamExample example);

    int deleteByExample(ExamExample example);

    int deleteByPrimaryKey(Integer examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    List<Exam> selectByExample(ExamExample example);

    Exam selectByPrimaryKey(Integer examid);

    int updateByExampleSelective(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByExample(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}