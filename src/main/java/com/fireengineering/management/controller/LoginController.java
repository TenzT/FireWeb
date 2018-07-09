package com.fireengineering.management.controller;

import com.fireengineering.management.util.JsonMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/fire")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {return "login";}


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    /**
     * 对登录页面输入的用户名和密码做简单的判断
     * @param request
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);
        if (!"admin1234".equals(username + password)){
            return JsonMsg.fail().addInfo("login_error", "输入账号用户名与密码不匹配，请重新输入！");
        }
        session.setAttribute("username", username);
        return JsonMsg.success();
    }


    /**
     * 退出登录：从主页面跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("username");
        return "login";
    }
}
