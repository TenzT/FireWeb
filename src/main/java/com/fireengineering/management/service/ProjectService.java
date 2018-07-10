package com.fireengineering.management.service;

import com.fireengineering.management.po.Project;

import java.util.List;

public interface ProjectService {

    public int deleteProjectById(Integer sysId);

    public int updateProjectById(Project project);

    public Project getProjectByName(String projectName);

    public int addProject(Project project);

    public int getProjectCount();

    public Project getProjectById(Integer projectId);

    public List<Project> getProjectList(Integer offset, Integer limit);

    public List<Project> getAllProject();

}
