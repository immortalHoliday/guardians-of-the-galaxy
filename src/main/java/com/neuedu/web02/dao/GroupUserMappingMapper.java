package com.neuedu.web02.dao;

import com.neuedu.web02.entity.GroupUserMapping;
import com.neuedu.web02.entity.GroupUserMappingExample;
import com.neuedu.web02.entity.GroupUserMappingKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupUserMappingMapper {
    int countByExample(GroupUserMappingExample example);

    int deleteByExample(GroupUserMappingExample example);

    int deleteByPrimaryKey(GroupUserMappingKey key);

    int insert(GroupUserMapping record);

    int insertSelective(GroupUserMapping record);

    List<GroupUserMapping> selectByExample(GroupUserMappingExample example);

    GroupUserMapping selectByPrimaryKey(GroupUserMappingKey key);

    int updateByExampleSelective(@Param("record") GroupUserMapping record, @Param("example") GroupUserMappingExample example);

    int updateByExample(@Param("record") GroupUserMapping record, @Param("example") GroupUserMappingExample example);

    int updateByPrimaryKeySelective(GroupUserMapping record);

    int updateByPrimaryKey(GroupUserMapping record);
}