package com.neuedu.web02.dao;

import com.neuedu.web02.entity.PaperFolder;
import com.neuedu.web02.entity.PaperFolderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperFolderMapper {
    int countByExample(PaperFolderExample example);

    int deleteByExample(PaperFolderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaperFolder record);

    int insertSelective(PaperFolder record);

    List<PaperFolder> selectByExample(PaperFolderExample example);

    PaperFolder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaperFolder record, @Param("example") PaperFolderExample example);

    int updateByExample(@Param("record") PaperFolder record, @Param("example") PaperFolderExample example);

    int updateByPrimaryKeySelective(PaperFolder record);

    int updateByPrimaryKey(PaperFolder record);
}