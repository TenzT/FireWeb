package com.fireengineering.management.service;

import com.fireengineering.management.po.Deployment;

import java.util.List;

public interface DeploymentService {
    public int getDeploymentCount();

    public Deployment getDeploymentById(Integer deploymentId);

    public List<Deployment> getDeploymentList(Integer offset, Integer limit);

    public int deleteDeploymentById(Integer deploymentId);

    public int addDeployment(Deployment deployment);

    public int updateDeploymentById(Deployment deployment);
}
