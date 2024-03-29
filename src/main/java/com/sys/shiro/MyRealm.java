package com.sys.shiro;

import com.sys.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
public class MyRealm  extends AuthorizingRealm {

    @Autowired
    private ILoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      log.info(">>>>>{}>>>>{}>>>>>{}>>>>","MyRealm","doGetAuthorizationInfo","PrincipalCollection");
       //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
//        User user = loginService.getUserByName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (Role role : user.getRoles()) {
//            //添加角色
//            simpleAuthorizationInfo.addRole(role.getRoleName());
//            //添加权限
//            for (Permissions permissions : role.getPermissions()) {
//                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
//            }
//        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info(">>>>>{}>>>>{}>>>>>{}>>>>","MyRealm","doGetAuthorizationInfo","AuthenticationToken");
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
//        String name = authenticationToken.getPrincipal().toString();
//        User user = loginService.getUserByName(name);
//        if (user == null) {
//            //这里返回后会报出对应异常
//            return null;
//        } else {
//            //这里验证authenticationToken和simpleAuthenticationInfo的信息
//            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
//            return simpleAuthenticationInfo;
//        }
        return null;
    }
}
