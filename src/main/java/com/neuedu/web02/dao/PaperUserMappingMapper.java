package com.neuedu.web02.dao;

import com.neuedu.web02.entity.PaperUserMapping;
import com.neuedu.web02.entity.PaperUserMappingExample;
import com.neuedu.web02.entity.PaperUserMappingKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PaperUserMappingMapper {
    int countByExample(PaperUserMappingExample example);

    int deleteByExample(PaperUserMappingExample example);

    int deleteByPrimaryKey(PaperUserMappingKey key);

    int insert(PaperUserMapping record);

    int insertSelective(PaperUserMapping record);

    List<PaperUserMapping> selectByExample(PaperUserMappingExample example);

    PaperUserMapping selectByPrimaryKey(PaperUserMappingKey key);

    int updateByExampleSelective(@Param("record") PaperUserMapping record, @Param("example") PaperUserMappingExample example);

    int updateByExample(@Param("record") PaperUserMapping record, @Param("example") PaperUserMappingExample example);

    int updateByPrimaryKeySelective(PaperUserMapping record);

    int updateByPrimaryKey(PaperUserMapping record);
}