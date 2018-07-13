package com.fireengineering.management.service.impl;

import com.fireengineering.management.mapper.DeploymentMapper;
import com.fireengineering.management.po.Deployment;
import com.fireengineering.management.po.DeploymentExample;
import com.fireengineering.management.service.DeploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeploymentServiceImpl implements DeploymentService {
    @Autowired
    DeploymentMapper deploymentMapper;

    public int getDeploymentCount() {
        DeploymentExample example = new DeploymentExample();
        return deploymentMapper.countByExample(example);

    }

    public Deployment getDeploymentById(Integer deploymentId) {
        return deploymentMapper.selectWithPoById(deploymentId);
    }


    public List<Deployment> getDeploymentList(Integer offset, Integer limit) {
        return deploymentMapper.selectByLimitAndOffset(offset, limit);
    }

    public int deleteDeploymentById(Integer deploymentId){
        return deploymentMapper.deleteByPrimaryKey(deploymentId);
    }

    public int addDeployment(Deployment deployment) {
        return deploymentMapper.insert(deployment);
    }

    public int updateDeploymentById(Deployment deployment) {
        return deploymentMapper.updateByPrimaryKey(deployment);
    }
}
