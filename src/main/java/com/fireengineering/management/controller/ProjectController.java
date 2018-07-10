package com.fireengineering.management.controller;

import com.fireengineering.management.po.Project;
import com.fireengineering.management.service.ProjectService;
import com.fireengineering.management.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/fire/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /**
     * 删除
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/delProject/{projectId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteDept(@PathVariable("projectId") Integer projectId){
        int res = 0;
        if (projectId > 0){
            res = projectService.deleteProjectById(projectId);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("del_proj_error", "删除异常");
        }
        return JsonMsg.success();
    }

    /**
     * 删除所有项目
     */
//    @RequestMapping(value = "/clearAllDept", method = RequestMethod.GET)
//    public String clearAllDept(){
//        departmentService.deleteAllDept();
//        return "redirect:/hrms/dept/getDeptList";
//    }

    /**
     * 系统更改
     * @param projectId
     * @param project
     * @return
     */
    @RequestMapping(value = "/updateProject/{projectId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updateDeptById(@PathVariable("projectId") Integer projectId, Project project){

        int res = 0;
        if (projectId > 0){
            project.setId(projectId);
            res = projectService.updateProjectById(project);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("update_proj_error", "系统更新失败");
        }
        return JsonMsg.success();
    }

    /**
     * 查询输入的系统名称是否重复
     * @param projectName
     * @return
     */
    @RequestMapping(value = "/checkFireystemExists", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg checkEmpExists(@RequestParam("projectName") String projectName){
        //对输入的姓名与邮箱格式进行验证
        String regName = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u4E00-\\u9FA5]{2,10})";
        if(!projectName.matches(regName)){
            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-5位中文或6-16位英文和数字组合");
        }
        Project project = projectService.getProjectByName(projectName);
        if (project != null){
            return JsonMsg.fail().addInfo("name_reg_error", "项目名重复");
        }else {
            return JsonMsg.success();
        }
    }

    /**
     * 新增消防系统
     * @param project
     * @return
     */
    @RequestMapping(value = "/addProject", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg addDept(Project project){
        int res = projectService.addProject(project);
        if (res != 1){
            return JsonMsg.fail().addInfo("add_proj_error", "添加异常！");
        }
        return JsonMsg.success();
    }

    /**
     * 查询系统信息总页码数
     * @return
     */
    @RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getTotalPages(){

        //每页显示的记录行数
        int limit = 5;
        //总记录数
        int totalItems = projectService.getProjectCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;

        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 根据id查找项目信息
     * @param projectId
     * @return
     */

    @RequestMapping(value = "/getProjectById/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getDeptById(@PathVariable("projectId") Integer projectId){
        Project project = null;
        if (projectId > 0){
            project = projectService.getProjectById(projectId);
        }
        if (project != null){
            return JsonMsg.success().addInfo("project", project);
        }
        return JsonMsg.fail().addInfo("get_projecttem_error", "无系统信息");
    }

    /**
     * 分页查询：返回指定页数对应的数据
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/getProjectList", method = RequestMethod.GET)
    public ModelAndView getDeptList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("projectPage");
        //每页显示的记录行数
        int limit = 5;
        //总记录数
        int totalItems = projectService.getProjectCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;
        //每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
        int offset = (pageNo - 1)*limit;
        List<Project> projects = projectService.getProjectList(offset, limit);

        mv.addObject("projects", projects)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPageNo", pageNo);
        return mv;
    }

    /**
     * 查询所有系统
     * @return
     */
    @RequestMapping(value = "/getAllProject", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getDeptName(){
        List<Project> projects = projectService.getAllProject();
        if (projects != null){
            return JsonMsg.success().addInfo("projects", projects);
        }
        return JsonMsg.fail();
    }
}
