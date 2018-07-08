package com.fireengineering.management.mapper;

import com.fireengineering.management.po.System;
import com.fireengineering.management.po.SystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMapper {
    int countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer systemId);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer systemId);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);
}