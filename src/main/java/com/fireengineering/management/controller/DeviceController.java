package com.fireengineering.management.controller;

import com.fireengineering.management.po.Device;
import com.fireengineering.management.service.DeviceService;
import com.fireengineering.management.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "fire/device")
public class DeviceController {
    @Autowired
    DeviceService devicesService;

    /**
     * 设备删除操作
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/deleteDevice/{deviceId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteDevice(@PathVariable("deviceId") Integer deviceId){
        int res = 0;
        if (deviceId > 0){
            res = devicesService.deleteDeviceById(deviceId);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("dev_del_error", "设备删除异常");
        }
        return JsonMsg.success();
    }

//    /**
//     * 删除所有员工
//     * @return
//     */
//    @RequestMapping(value = "/clearAllEmp", method = RequestMethod.GET)
////    @ResponseBody
//    public String clearAllEmp() {
//        employeeService.deleteAllEmp();
//        return "redirect:/hrms/emp/getEmpList";
//    }

    /**
     * 更改设备信息
     * @param deviceId
     * @param device
     * @return
     */
    @RequestMapping(value ="/updateDevice/{deviceId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updateEmp(@PathVariable("deviceId") Integer deviceId,  Device device){
        device.setId(deviceId);
        int res = devicesService.updateDeviceById(device);
        if (res != 1){
            return JsonMsg.fail().addInfo("dev_update_error", "更改异常");
        }
        return JsonMsg.success();
    }

    /**
     * 查询输入的设备姓名是否重复
     * @param deviceName
     * @return
     */
    @RequestMapping(value = "/checkDeviceExists", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg checkEmpExists(@RequestParam("deviceName") String deviceName){
        //对输入的姓名与邮箱格式进行验证
        String regName = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u4E00-\\u9FA5]{2,20})";
        if(!deviceName.matches(regName)){
            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-20位中文或6-16位英文和数字组合");
        }
        Device device = devicesService.getDeviceByName(deviceName);
        if (device != null){
            return JsonMsg.fail().addInfo("name_reg_error", "设备名重复");
        }else {
            return JsonMsg.success();
        }
    }

    /**
     * 新增设备后，查询最新的页数
     * @return
     */
    @RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getTotalPage(){
        int totalItems = devicesService.getDeviceCount();
        //获取总的页数
        int temp = totalItems / 5;
        int totalPages = (totalItems % 5 == 0) ? temp : temp+1;
        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 新增设备
     * @param device
     * @return
     */
    @RequestMapping(value = "/addDevice", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addEmp(Device device){
        int res = devicesService.addDevice(device);
        if (res == 1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }

    /**
     * 根据id查询设备信息
     * @param deviceId
     * @return
     */
    @RequestMapping(value = "/getDeviceById/{deviceId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getEmpById(@PathVariable("deviceId") Integer deviceId){
        Device device = devicesService.getDeviceById(deviceId);
        if (device != null){
            return JsonMsg.success().addInfo("device", device);
        }else {
            return JsonMsg.fail();
        }

    }

    /**
     * 查询
     * @param pageNo 查询指定页码包含的数据
     * @return
     */
    @RequestMapping(value = "/getDeviceList", method = RequestMethod.GET)
    public ModelAndView getDevice(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("devicePage");
        int limit = 5;
        // 记录的偏移量(即从第offset行记录开始查询)，
        // 如第1页是从第1行(offset=(21-1)*5=0,offset+1=0+1=1)开始查询；
        // 第2页从第6行(offset=(2-1)*5=5,offset+1=5+1=6)记录开始查询
        int offset = (pageNo-1)*limit;
        //获取指定页数包含的员工信息
        List<Device> devices = devicesService.getDeviceList(offset, limit);
        //获取总的记录数
        int totalItems = devicesService.getDeviceCount();
        //获取总的页数
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit == 0) ? temp : temp+1;
        //当前页数
        int curPage = pageNo;

        //将上述查询结果放到Model中，在JSP页面中可以进行展示
        mv.addObject("devices", devices)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPage", curPage);
        return mv;
    }
}
