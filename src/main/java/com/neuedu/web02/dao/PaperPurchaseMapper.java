package com.neuedu.web02.dao;

import com.neuedu.web02.entity.PaperPurchase;
import com.neuedu.web02.entity.PaperPurchaseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PaperPurchaseMapper {
    int countByExample(PaperPurchaseExample example);

    int deleteByExample(PaperPurchaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaperPurchase record);

    int insertSelective(PaperPurchase record);

    List<PaperPurchase> selectByExample(PaperPurchaseExample example);

    PaperPurchase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaperPurchase record, @Param("example") PaperPurchaseExample example);

    int updateByExample(@Param("record") PaperPurchase record, @Param("example") PaperPurchaseExample example);

    int updateByPrimaryKeySelective(PaperPurchase record);

    int updateByPrimaryKey(PaperPurchase record);
}