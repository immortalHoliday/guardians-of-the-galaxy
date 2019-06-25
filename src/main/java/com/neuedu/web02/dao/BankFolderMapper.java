package com.neuedu.web02.dao;

import com.neuedu.web02.entity.BankFolder;
import com.neuedu.web02.entity.BankFolderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BankFolderMapper {
    int countByExample(BankFolderExample example);

    int deleteByExample(BankFolderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BankFolder record);

    int insertSelective(BankFolder record);

    List<BankFolder> selectByExample(BankFolderExample example);

    BankFolder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BankFolder record, @Param("example") BankFolderExample example);

    int updateByExample(@Param("record") BankFolder record, @Param("example") BankFolderExample example);

    int updateByPrimaryKeySelective(BankFolder record);

    int updateByPrimaryKey(BankFolder record);
}