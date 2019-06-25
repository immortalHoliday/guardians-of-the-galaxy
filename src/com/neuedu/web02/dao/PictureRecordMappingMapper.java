package com.neuedu.web02.dao;

import com.neuedu.web02.entity.PictureRecordMapping;
import com.neuedu.web02.entity.PictureRecordMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureRecordMappingMapper {
    int countByExample(PictureRecordMappingExample example);

    int deleteByExample(PictureRecordMappingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PictureRecordMapping record);

    int insertSelective(PictureRecordMapping record);

    List<PictureRecordMapping> selectByExample(PictureRecordMappingExample example);

    PictureRecordMapping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PictureRecordMapping record, @Param("example") PictureRecordMappingExample example);

    int updateByExample(@Param("record") PictureRecordMapping record, @Param("example") PictureRecordMappingExample example);

    int updateByPrimaryKeySelective(PictureRecordMapping record);

    int updateByPrimaryKey(PictureRecordMapping record);
}