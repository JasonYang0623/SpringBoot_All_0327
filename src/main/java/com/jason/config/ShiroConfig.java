package com.jason.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason
 * @date 2023/4/4 9:22
 * @content
 */
@Configuration
public class ShiroConfig {
    @Bean
    public MyRealm myRealm(){
        return  new MyRealm();
    }
    //创建具有web特性的securityManager
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilter=new ShiroFilterFactoryBean();
        //给shiroFilter注入securityManager
        shiroFilter.setSecurityManager(securityManager());
        //设置默认认证路径，失败后会调用
        shiroFilter.setLoginUrl("/");
        //添加自己的过滤器并且取名为jwt
        shiroFilter.setUnauthorizedUrl("/error");
        //创建过滤器链
        Map<String,String> map=new HashMap<String,String>();
        map.put("/users/login","anon");
        map.put("/users/register","anon");
        map.put("/users/logout","logout");
        map.put("/error","anon");
        map.put("/books/list","authc");
        shiroFilter.setFilterChainDefinitionMap(map);
        return shiroFilter;
    }
}
