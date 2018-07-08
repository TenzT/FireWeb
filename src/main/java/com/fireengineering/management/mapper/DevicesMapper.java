package com.fireengineering.management.mapper;

import com.fireengineering.management.po.Devices;
import com.fireengineering.management.po.DevicesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevicesMapper {
    int countByExample(DevicesExample example);

    int deleteByExample(DevicesExample example);

    int deleteByPrimaryKey(Integer deviceId);

    int insert(Devices record);

    int insertSelective(Devices record);

    List<Devices> selectByExample(DevicesExample example);

    Devices selectByPrimaryKey(Integer deviceId);

    int updateByExampleSelective(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByExample(@Param("record") Devices record, @Param("example") DevicesExample example);

    int updateByPrimaryKeySelective(Devices record);

    int updateByPrimaryKey(Devices record);
}