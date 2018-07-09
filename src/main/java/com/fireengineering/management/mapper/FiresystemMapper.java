package com.fireengineering.management.mapper;

import com.fireengineering.management.po.Firesystem;
import com.fireengineering.management.po.FiresystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FiresystemMapper {
    int countByExample(FiresystemExample example);

    int deleteByExample(FiresystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Firesystem record);

    int insertSelective(Firesystem record);

    List<Firesystem> selectByExample(FiresystemExample example);

    Firesystem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Firesystem record, @Param("example") FiresystemExample example);

    int updateByExample(@Param("record") Firesystem record, @Param("example") FiresystemExample example);

    int updateByPrimaryKeySelective(Firesystem record);

    int updateByPrimaryKey(Firesystem record);

    List<Firesystem> selectByLimitAndOffset(@Param("offset") Integer offset, @Param("limit")Integer limit);

    Firesystem selectByName(@Param("firesystemName")String firesystemName);
}