package com.fireengineering.management.controller;

import com.fireengineering.management.po.Deployment;
import com.fireengineering.management.service.DeploymentService;
import com.fireengineering.management.util.JsonMsg;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping(value = "/fire/deployment")
public class DeploymentController {
    @Autowired
    DeploymentService deploymentsService;

    /**
     * 部署删除操作
     * @param deploymentId
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "/deleteDeployment/{deploymentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteDeployment(@PathVariable("deploymentId") Integer deploymentId){
        int res = 0;
        if (deploymentId > 0){
            res = deploymentsService.deleteDeploymentById(deploymentId);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("dev_del_error", "部署删除异常");
        }
        return JsonMsg.success();
    }

//    /**
//     * 删除所有员工
//     * @return
//     */
//    @RequestMapping(value = "/clearAllDeployment", method = RequestMethod.GET)
////    @ResponseBody
//    public String clearAllDeployment() {
//        employeeService.deleteAllDeployment();
//        return "redirect:/hrms/emp/getDeploymentList";
//    }

    /**
     * 更改部署信息
     * @param deploymentId
     * @param deployment
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping(value ="/updateDeployment/{deploymentId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updateDeployment(@PathVariable("deploymentId") Integer deploymentId,  Deployment deployment){
        deployment.setId(deploymentId);
        int res = deploymentsService.updateDeploymentById(deployment);
        if (res != 1){
            return JsonMsg.fail().addInfo("dev_update_error", "更改异常");
        }
        return JsonMsg.success();
    }

    /**
     * 新增部署后，查询最新的页数
     * @return
     */
    @RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getTotalPage(){
        int totalItems = deploymentsService.getDeploymentCount();
        //获取总的页数
        int temp = totalItems / 5;
        int totalPages = (totalItems % 5 == 0) ? temp : temp+1;
        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 新增部署
     * @param deployment
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "/addDeployment", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addDeployment(Deployment deployment){
        int res = deploymentsService.addDeployment(deployment);
        if (res == 1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }

    /**
     * 根据id查询部署信息
     * @param deploymentId
     * @return
     */
    @RequestMapping(value = "/getDeploymentById/{deploymentId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getDeploymentById(@PathVariable("deploymentId") Integer deploymentId){
        Deployment deployment = deploymentsService.getDeploymentById(deploymentId);
        if (deployment != null){
            return JsonMsg.success().addInfo("deployment", deployment);
        }else {
            return JsonMsg.fail();
        }

    }

    /**
     * 查询
     * @param pageNo 查询指定页码包含的数据
     * @return
     */
    @RequestMapping(value = "/getDeploymentList", method = RequestMethod.GET)
    public ModelAndView getDeployment(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("deploymentPage");
        int limit = 5;
        // 记录的偏移量(即从第offset行记录开始查询)，
        // 如第1页是从第1行(offset=(21-1)*5=0,offset+1=0+1=1)开始查询；
        // 第2页从第6行(offset=(2-1)*5=5,offset+1=5+1=6)记录开始查询
        int offset = (pageNo-1)*limit;
        //获取指定页数包含的员工信息
        List<Deployment> deployments = deploymentsService.getDeploymentList(offset, limit);
        //获取总的记录数
        int totalItems = deploymentsService.getDeploymentCount();
        //获取总的页数
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit == 0) ? temp : temp+1;
        //当前页数
        int curPage = pageNo;

        //将上述查询结果放到Model中，在JSP页面中可以进行展示
        mv.addObject("deployments", deployments)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPage", curPage);
        return mv;
    }

    @RequestMapping(value = "/getAllDeployment", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getAllDeployment(){
        List<Deployment> deployments = deploymentsService.getAllDeployment();
        if (deployments != null){
            return JsonMsg.success().addInfo("deployments", deployments);
        }
        return JsonMsg.fail();
    }
}
