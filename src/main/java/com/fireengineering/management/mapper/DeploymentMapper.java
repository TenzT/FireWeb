package com.fireengineering.management.mapper;

import com.fireengineering.management.po.Deployment;
import com.fireengineering.management.po.DeploymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeploymentMapper {
    int countByExample(DeploymentExample example);

    int deleteByExample(DeploymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Deployment record);

    int insertSelective(Deployment record);

    List<Deployment> selectByExample(DeploymentExample example);

    Deployment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Deployment record, @Param("example") DeploymentExample example);

    int updateByExample(@Param("record") Deployment record, @Param("example") DeploymentExample example);

    int updateByPrimaryKeySelective(Deployment record);

    int updateByPrimaryKey(Deployment record);

    List<Deployment> selectByLimitAndOffset(@Param("offset") Integer offset, @Param("limit")Integer limit);

    Deployment selectWithPoById(@Param("deploymentId") Integer deploymentId);
}