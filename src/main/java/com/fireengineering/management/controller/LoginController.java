package com.fireengineering.management.controller;

import com.fireengineering.management.po.User;
import com.fireengineering.management.service.UserService;
import com.fireengineering.management.util.JsonMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/fire")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {return "login";}


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    /**
     * 对登录页面输入的用户名和密码做简单的判断
     * @param
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public JsonMsg dologin(String username, String password,HttpSession session){
        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(username+password);
        try{
            userSubject.login(token);
        } catch (AuthenticationException e) {
            return JsonMsg.fail().addInfo("login_error", "输入账号用户名与密码不匹配，请重新输入！");
        }
        User user = userService.getUserByUsername(username);

        session.setAttribute("userName", user.getName());
        session.setAttribute("userId", user.getId());
        session.setAttribute("userSubject", userSubject);
        return JsonMsg.success();
    }


    /**
     * 退出登录：从主页面跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession){
        Subject userSubject = (Subject) httpSession.getAttribute("userSubject");
        userSubject.logout();
        return "login";
    }
}
