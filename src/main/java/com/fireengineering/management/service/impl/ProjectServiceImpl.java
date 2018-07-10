package com.fireengineering.management.service.impl;

import com.fireengineering.management.mapper.ProjectMapper;
import com.fireengineering.management.po.Project;
import com.fireengineering.management.po.ProjectExample;
import com.fireengineering.management.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    public int deleteProjectById(Integer sysId) {
        return projectMapper.deleteByPrimaryKey(sysId);
    }

    public int updateProjectById(Project project){
        return projectMapper.updateByPrimaryKey(project);
    }

    public Project getProjectByName(String projectName) {
        return projectMapper.selectByName(projectName);
    }

    public int addProject(Project project) {
        return projectMapper.insert(project);
    }

    public int getProjectCount(){
        ProjectExample example = new ProjectExample();
        return projectMapper.countByExample(example);
    }

    public Project getProjectById(Integer projectId) {
        return projectMapper.selectByPrimaryKey(projectId);
    }

    public List<Project> getProjectList(Integer offset, Integer limit){
        return projectMapper.selectByLimitAndOffset(offset,limit);
    }

    public List<Project> getAllProject() {
        ProjectExample example = new ProjectExample();
        return projectMapper.selectByExample(example);
    }

}
