package com.jason.config;

import com.jason.domain.User;
import com.jason.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jason
 * @date 2023/4/4 9:06
 * @content
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IUserService iUserService;

    /**
     * 鉴权操作
     * @param principalCollection 前端传递的登录凭证
     * @return 返回鉴权对象
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用户认证
     * @param authenticationToken 认证token
     * @return  返回认证对象
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取登录凭证
        String username=authenticationToken.getPrincipal().toString();
        //2. 根据用户名从数据库中获取对象
        User currentUser=iUserService.getCurretUserByUsername(username);
        //3.获取用户密码，盐值。shiro自动认证
        if (null==currentUser){
            return null;
        }
        return new SimpleAuthenticationInfo(username,currentUser.getPassword(),this.getName());
    }
}
