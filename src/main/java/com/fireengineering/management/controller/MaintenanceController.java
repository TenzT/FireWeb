package com.fireengineering.management.controller;

import com.fireengineering.management.po.Maintenance;
import com.fireengineering.management.service.MaintenanceService;
import com.fireengineering.management.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping(value = "/fire/maintenance")
public class MaintenanceController {
    @Autowired
    MaintenanceService maintenancesService;

    /**
     * 设备删除操作
     * @param maintenanceId
     * @return
     */
    @RequestMapping(value = "/deleteMaintenance/{maintenanceId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteMaintenance(@PathVariable("maintenanceId") Integer maintenanceId){
        int res = 0;
        if (maintenanceId > 0){
            res = maintenancesService.deleteMaintenanceById(maintenanceId);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("main_del_error", "设备删除异常");
        }
        return JsonMsg.success();
    }

//    /**
//     * 删除所有员工
//     * @return
//     */
//    @RequestMapping(value = "/clearAllMaintenance", method = RequestMethod.GET)
////    @ResponseBody
//    public String clearAllMaintenance() {
//        employeeService.deleteAllMaintenance();
//        return "redirect:/hrms/emp/getMaintenanceList";
//    }

    /**
     * 更改设备信息
     * @param maintenanceId
     * @param maintenance
     * @return
     */
    @RequestMapping(value ="/updateMaintenance/{maintenanceId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updateMaintenance(@PathVariable("maintenanceId") Integer maintenanceId,  Maintenance maintenance){
        maintenance.setId(maintenanceId);
        int res = maintenancesService.updateMaintenanceById(maintenance);
        if (res != 1){
            return JsonMsg.fail().addInfo("main_update_error", "更改异常");
        }
        return JsonMsg.success();
    }

//    /**
//     * 查询输入的设备姓名是否重复
//     * @param maintenanceName
//     * @return
//     */
//    @RequestMapping(value = "/checkMaintenanceExists", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonMsg checkMaintenanceExists(@RequestParam("maintenanceName") String maintenanceName){
//        //对输入的姓名与邮箱格式进行验证
//        String regName = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u4E00-\\u9FA7]{2,20})";
//        if(!maintenanceName.matches(regName)){
//            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-20位中文或6-16位英文和数字组合");
//        }
//        Maintenance maintenance = maintenancesService.getMaintenanceByName(maintenanceName);
//        if (maintenance != null){
//            return JsonMsg.fail().addInfo("name_reg_error", "设备名重复");
//        }else {
//            return JsonMsg.success();
//        }
//    }

    /**
     * 新增设备后，查询最新的页数
     * @return
     */
    @RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getTotalPage(){
        int totalItems = maintenancesService.getMaintenanceCount();
        //获取总的页数
        int temp = totalItems / 7;
        int totalPages = (totalItems % 7 == 0) ? temp : temp+1;
        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 新增设备
     * @param maintenance
     * @return
     */
    @RequestMapping(value = "/addMaintenance", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addMaintenance(Maintenance maintenance){
        int res = maintenancesService.addMaintenance(maintenance);
        if (res == 1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }

//    /**
//     * 根据id查询设备信息
//     * @param maintenanceId
//     * @return
//     */
//    @RequestMapping(value = "/getMaintenanceById/{maintenanceId}", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonMsg getMaintenanceById(@PathVariable("maintenanceId") Integer maintenanceId){
//        Maintenance maintenance = maintenancesService.getMaintenanceById(maintenanceId);
//        if (maintenance != null){
//            return JsonMsg.success().addInfo("maintenance", maintenance);
//        }else {
//            return JsonMsg.fail();
//        }
//
//    }

    /**
     * 查询
     * @param pageNo 查询指定页码包含的数据
     * @return
     */
    @RequestMapping(value = "/getMaintenanceList", method = RequestMethod.GET)
    public ModelAndView getMaintenance(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("maintenancePage");
        int limit = 7;
        // 记录的偏移量(即从第offset行记录开始查询)，
        // 如第1页是从第1行(offset=(21-1)*7=0,offset+1=0+1=1)开始查询；
        // 第2页从第6行(offset=(2-1)*7=7,offset+1=7+1=6)记录开始查询
        int offset = (pageNo-1)*limit;
        //获取指定页数包含的员工信息
        List<Maintenance> maintenances = maintenancesService.getMaintenanceList(offset, limit);
        //获取总的记录数
        int totalItems = maintenancesService.getMaintenanceCount();
        //获取总的页数
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit == 0) ? temp : temp+1;
        //当前页数
        int curPage = pageNo;

        //将上述查询结果放到Model中，在JSP页面中可以进行展示
        mv.addObject("maintenances", maintenances)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPage", curPage);
        return mv;
    }
//    @RequestMapping(value = "/getAllMaintenance", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonMsg getAllMaintenance(){
//        List<Maintenance> maintenances = maintenancesService.getAllMaintenance();
//        if (maintenances != null){
//            return JsonMsg.success().addInfo("maintenances", maintenances);
//        }
//        return JsonMsg.fail();
//    }

}
