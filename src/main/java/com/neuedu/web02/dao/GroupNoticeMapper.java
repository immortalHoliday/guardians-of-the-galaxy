package com.neuedu.web02.dao;

import com.neuedu.web02.entity.GroupNotice;
import com.neuedu.web02.entity.GroupNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupNoticeMapper {
    int countByExample(GroupNoticeExample example);

    int deleteByExample(GroupNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupNotice record);

    int insertSelective(GroupNotice record);

    List<GroupNotice> selectByExample(GroupNoticeExample example);

    GroupNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupNotice record, @Param("example") GroupNoticeExample example);

    int updateByExample(@Param("record") GroupNotice record, @Param("example") GroupNoticeExample example);

    int updateByPrimaryKeySelective(GroupNotice record);

    int updateByPrimaryKey(GroupNotice record);
}