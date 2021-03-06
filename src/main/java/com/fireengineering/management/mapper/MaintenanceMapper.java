package com.fireengineering.management.mapper;

import com.fireengineering.management.po.Maintenance;
import com.fireengineering.management.po.MaintenanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaintenanceMapper {
    int countByExample(MaintenanceExample example);

    int deleteByExample(MaintenanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Maintenance record);

    int insertSelective(Maintenance record);

    List<Maintenance> selectByExample(MaintenanceExample example);

    Maintenance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Maintenance record, @Param("example") MaintenanceExample example);

    int updateByExample(@Param("record") Maintenance record, @Param("example") MaintenanceExample example);

    int updateByPrimaryKeySelective(Maintenance record);

    int updateByPrimaryKey(Maintenance record);

    List<Maintenance> selectByLimitAndOffset(@Param("offset") Integer offset, @Param("limit")Integer limit);
}