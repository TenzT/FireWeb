package com.fireengineering.management.service;

import com.fireengineering.management.po.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-**.xml"})
public class ProjectServiceTest {
    @Autowired
    ProjectService projectService;
    @Test
    public void deleteProjectById() {
    }

    @Test
    public void updateProjectById() {
    }

    @Test
    public void getProjectByName() {
    }

    @Test
    public void addProject() {
        Project project = new Project();
        project.setName("星巴克");
        projectService.addProject(project);
    }

    @Test
    public void getProjectCount() {
    }

    @Test
    public void getProjectById() {
    }

    @Test
    public void getProjectList() {
    }

    @Test
    public void getAllProject() {
    }
}