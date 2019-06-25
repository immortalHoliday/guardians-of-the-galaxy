package com.neuedu.web02.dao;

import com.neuedu.web02.entity.BankPurchase;
import com.neuedu.web02.entity.BankPurchaseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BankPurchaseMapper {
    int countByExample(BankPurchaseExample example);

    int deleteByExample(BankPurchaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BankPurchase record);

    int insertSelective(BankPurchase record);

    List<BankPurchase> selectByExample(BankPurchaseExample example);

    BankPurchase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BankPurchase record, @Param("example") BankPurchaseExample example);

    int updateByExample(@Param("record") BankPurchase record, @Param("example") BankPurchaseExample example);

    int updateByPrimaryKeySelective(BankPurchase record);

    int updateByPrimaryKey(BankPurchase record);
}