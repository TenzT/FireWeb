package com.fireengineering.management.controller;

import com.fireengineering.management.po.Place;
import com.fireengineering.management.service.PlaceService;
import com.fireengineering.management.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "fire/place")
public class PlaceController {
    @Autowired
    PlaceService placesService;

    /**
     * 设备删除操作
     * @param placeId
     * @return
     */
    @RequestMapping(value = "/deletePlace/{placeId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deletePlace(@PathVariable("placeId") Integer placeId){
        int res = 0;
        if (placeId > 0){
            res = placesService.deletePlaceById(placeId);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("place_del_error", "设备删除异常");
        }
        return JsonMsg.success();
    }

//    /**
//     * 删除所有员工
//     * @return
//     */
//    @RequestMapping(value = "/clearAllPlace", method = RequestMethod.GET)
////    @ResponseBody
//    public String clearAllPlace() {
//        employeeService.deleteAllPlace();
//        return "redirect:/hrms/emp/getPlaceList";
//    }

    /**
     * 更改设备信息
     * @param placeId
     * @param place
     * @return
     */
    @RequestMapping(value ="/updatePlace/{placeId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonMsg updatePlace(@PathVariable("placeId") Integer placeId,  Place place){
        place.setId(placeId);
        int res = placesService.updatePlaceById(place);
        if (res != 1){
            return JsonMsg.fail().addInfo("place_update_error", "更改异常");
        }
        return JsonMsg.success();
    }

    /**
     * 查询输入的设备姓名是否重复
     * @param placeName
     * @return
     */
    @RequestMapping(value = "/checkPlaceExists", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg checkPlaceExists(@RequestParam("placeName") String placeName){
        //对输入的姓名与邮箱格式进行验证
        String regName = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u4E00-\\u9FA5]{2,20})";
        if(!placeName.matches(regName)){
            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-20位中文或6-16位英文和数字组合");
        }
        Place Place = placesService.getPlaceByName(placeName);
        if (Place != null){
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
        int totalItems = placesService.getPlaceCount();
        //获取总的页数
        int temp = totalItems / 5;
        int totalPages = (totalItems % 5 == 0) ? temp : temp+1;
        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 新增设备
     * @param place
     * @return
     */
    @RequestMapping(value = "/addPlace", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addPlace(Place place){
        int res = placesService.addPlace(place);
        if (res == 1){
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }

    /**
     * 根据id查询设备信息
     * @param PlaceId
     * @return
     */
    @RequestMapping(value = "/getPlaceById/{placeId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getPlaceById(@PathVariable("placeId") Integer PlaceId){
        Place place = placesService.getPlaceById(PlaceId);
        if (place != null){
            return JsonMsg.success().addInfo("place", place);
        }else {
            return JsonMsg.fail();
        }

    }

    /**
     * 查询
     * @param pageNo 查询指定页码包含的数据
     * @return
     */
    @RequestMapping(value = "/getPlaceList", method = RequestMethod.GET)
    public ModelAndView getPlace(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("placePage");
        int limit = 5;
        // 记录的偏移量(即从第offset行记录开始查询)，
        // 如第1页是从第1行(offset=(21-1)*5=0,offset+1=0+1=1)开始查询；
        // 第2页从第6行(offset=(2-1)*5=5,offset+1=5+1=6)记录开始查询
        int offset = (pageNo-1)*limit;
        //获取指定页数包含的员工信息
        List<Place> places = placesService.getPlaceList(offset, limit);
        //获取总的记录数
        int totalItems = placesService.getPlaceCount();
        //获取总的页数
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit == 0) ? temp : temp+1;
        //当前页数
        int curPage = pageNo;

        //将上述查询结果放到Model中，在JSP页面中可以进行展示
        mv.addObject("places", places)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPage", curPage);
        return mv;
    }

    @RequestMapping(value = "/getAllPlace", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getAllDevice(){
        List<Place> places = placesService.getAllPlace();
        if (places != null){
            return JsonMsg.success().addInfo("places", places);
        }
        return JsonMsg.fail();
    }
}
