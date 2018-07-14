package com.fireengineering.management.controller;

import com.fireengineering.management.po.User;
import com.fireengineering.management.service.UserService;
import com.fireengineering.management.util.JsonMsg;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;
import java.util.List;
@Controller
@RequestMapping(value = "/fire/user/")
public class UserController {
    @Autowired
    UserService userService;

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
        int totalItems = userService.getUserCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;

        return JsonMsg.success().addInfo("totalPages", totalPages);
    }

    /**
     * 分页查询：返回指定页数对应的数据
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ModelAndView getUserList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("userPage");
        //每页显示的记录行数
        int limit = 5;
        //总记录数
        int totalItems = userService.getUserCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;
        //每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
        int offset = (pageNo - 1)*limit;
        List<User> users = userService.getUserList(offset, limit);

        mv.addObject("users", users)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPageNo", pageNo);
        return mv;
    }

    @RequestMapping(value = "/delUser/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteUser(@PathVariable("userId") Integer userId){
        int res = 0;
        if (userId > 0){
            res = userService.deleteUserById(userId);
        }
        if (res != 1){
            return JsonMsg.fail().addInfo("del_user_error", "删除异常");
        }
        return JsonMsg.success();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg addUser(User user) {
        int res = userService.addUser(user);
        if (res != 1){
            return JsonMsg.fail().addInfo("add_user_error", "添加异常！");
        }
        return JsonMsg.success();
    }

    @RequestMapping(value = "/checkUsernameExists", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg checkUsernameExists(@RequestParam("userUsername") String userUsername) {
        //对输入的姓名与邮箱格式进行验证
        String regName = "(^[a-zA-Z0-9_]{4,16}$)";
        if(!userUsername.matches(regName)){
            return JsonMsg.fail().addInfo("name_reg_error", "输入姓名为2-5位中文或6-16位英文和数字组合");
        }
        User user = userService.getUserByUsername(userUsername);

        if (user != null){
            return JsonMsg.fail().addInfo("name_reg_error", "用户名重复");
        }else {
            return JsonMsg.success();
        }
    }

    @RequestMapping(value = "/getAllUserName", method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getAllUserName() {
        List<User> users = userService.getAllUserName();
        if (users != null){
            return JsonMsg.success().addInfo("users", users);
        }else {
            return JsonMsg.fail();
        }
    }
}
