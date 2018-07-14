package com.fireengineering.management.shiro.realm;

import com.fireengineering.management.po.User;
import com.fireengineering.management.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;



public class CustomRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String)principalCollection.getPrimaryPrincipal();

        //通过用户名获得密码
        User user = userService.getUserByUsername(userName);

        if(user!=null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole(user.getAuthority());
            return simpleAuthorizationInfo;
        }

        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从主体传过来的认证信息中获得用户名
        String userName = (String) authenticationToken.getPrincipal();

        //通过用户名获得密码
        User user = userService.getUserByUsername(userName);

        if (user.getPassword() != null) {
            return new SimpleAuthenticationInfo(userName, user.getPassword(),"myRealm");
        }
        return null;
    }
}
