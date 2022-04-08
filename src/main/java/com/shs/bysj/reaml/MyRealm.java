package com.shs.bysj.reaml;

import com.shs.bysj.pojo.Manager;
import com.shs.bysj.service.impl.ManagerService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;

    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        /**
         * 此处仍缺少相关用户的权限查询
         */
        return s;
    }
    //获取认证信息，根据token中的用户名查询数据库
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String name = token.getPrincipal().toString();
        Manager manager = managerService.findManagerByManagerName(name);
        if (manager == null) {
            throw new AuthenticationException();
        }
        String passwordDB = manager.getManagerPassword();
        String salt = manager.getManagerSalt();
        SimpleAuthenticationInfo  authenticationInfo =
                new SimpleAuthenticationInfo(name, passwordDB, ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}
