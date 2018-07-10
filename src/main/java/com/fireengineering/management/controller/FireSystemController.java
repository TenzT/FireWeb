package com.fireengineering.management.controller;

import com.fireengineering.management.po.Firesystem;
import com.fireengineering.management.service.FiresystemService;
import com.fireengineering.management.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/fire/firesystem")
public class FireSystemController {

    @Autowired
    FiresystemService firesystemService;

    /**
     * 删除
     * @param sysId
     * @return
     */
    @RequestMapping(value = "/delFireSystem/{sysId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteDept(@PathVariable("sysId") Integer sysId){
        int res = 0;
        if (sysId > 0){
            res = firesystemService.deleteFiresystemById(sysId);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("del_sys_error", "删除异常");
        }
        return JsonMsg.success();
    }

    /**
     * 删除所有系统
     */
//    @RequestMapping(value = "/clearAllDept", method = RequestMethod.GET)
//    public String clearAllDept(){
//        departmentService.deleteAllDept();
//        return "redirect:/hrms/dept/getDeptList";
//    }

    /**
     * 系统更改
     * @param firesystemId
     * @param firesystem
     * @return
     */
    @RequestMapping(value = "/updateFiresystem/{firesystemId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updateDeptById(@PathVariable("firesystemId") Integer firesystemId, Firesystem firesystem){

        int res = 0;
        if (firesystemId > 0){
            firesystem.setId(firesystemId);
            res = firesystemService.updateFiresystemById(firesystem);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("update_dept_error", "系统更新失败");
        }
        return JsonMsg.success();
    }

    /**
     * 查询输入的系统名称是否重复
     * @param firesystemName
     * @return
     */
    @RequestMapping(value = "/checkFireystemExists", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg checkEmpExists(@RequestParam("firesystemName") String firesystemName){
        //对输入的姓名与邮箱格式进行验证
        String regName = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u4E00-\\u9FA5]{2,10})";
        if(!firesystemName.matches(regName)){
            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-5位中文或6-16位英文和数字组合");
        }
        Firesystem firesystem = firesystemService.getFiresystemByName(firesystemName);
        if (firesystem != null){
            return JsonMsg.fail().addInfo("name_reg_error", "系统名重复");
        }else {
            return JsonMsg.success();
        }
    }

    /**
     * 新增消防系统
     * @param firesystem
     * @return
     */
    @RequestMapping(value = "/addFiresystem", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg addDept(Firesystem firesystem){
        int res = firesystemService.addFiresystem(firesystem);
        if (res != 1){
            return JsonMsg.fail().addInfo("add_system_error", "添加异常！");
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
        int totalItems = firesystemService.getFiresystemCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;

        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 根据id查找系统信息
     * @param firesystemId
     * @return
     */

    @RequestMapping(value = "/getFiresystemById/{firesystemId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getDeptById(@PathVariable("firesystemId") Integer firesystemId){
        Firesystem firesystem = null;
        if (firesystemId > 0){
            firesystem = firesystemService.getFiresystemById(firesystemId);
        }
        if (firesystem != null){
            return JsonMsg.success().addInfo("firesystem", firesystem);
        }
        return JsonMsg.fail().addInfo("get_system_error", "无系统信息");
    }

    /**
     * 分页查询：返回指定页数对应的数据
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/getFiresystemList", method = RequestMethod.GET)
    public ModelAndView getDeptList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("firesystemPage");
        //每页显示的记录行数
        int limit = 5;
        //总记录数
        int totalItems = firesystemService.getFiresystemCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;
        //每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
        int offset = (pageNo - 1)*limit;
        List<Firesystem> firesystems = firesystemService.getFiresystemList(offset, limit);

        mv.addObject("firesystems", firesystems)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPageNo", pageNo);
        return mv;
    }

    /**
     * 查询所有系统
     * @return
     */
    @RequestMapping(value = "/getAllFiresystem", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getDeptName(){
        List<Firesystem> firesystems = firesystemService.getAllFiresystem();
        if (firesystems != null){
            return JsonMsg.success().addInfo("firesystems", firesystems);
        }
        return JsonMsg.fail();
    }

}
