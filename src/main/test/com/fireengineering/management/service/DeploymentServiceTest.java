package com.fireengineering.management.service;

import com.fireengineering.management.po.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-**.xml"})
public class DeploymentServiceTest {
    @Autowired
    DeploymentService deploymentService;
    @Test
    public void getDeploymentCount() {
    }

    @Test
    public void getDeploymentById() {
    }

    @Test
    public void getDeploymentList() {
        List<Deployment> list = deploymentService.getDeploymentList(0,10);
        for(Deployment d:list) {
            System.out.println(d.getDevice().getName());
        }
    }

    @Test
    public void deleteDeploymentById() {
        Deployment deployment = deploymentService.getDeploymentById(2);
        System.out.println(deployment.getDevice().getName());
    }

    @Test
    public void addDeployment() {
    }

    @Test
    public void updateDeploymentById() {
    }
}