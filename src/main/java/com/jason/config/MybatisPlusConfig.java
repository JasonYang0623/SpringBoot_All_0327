package com.jason.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jason
 * @date 2023/3/28 10:46
 * @content 实现分页查询
 * 这段代码定义了一个名为MybatisPlusConfig的类，并使用@Configuration注解将其标记为一个配置类。这个类中定义了一个名为mybatisPlusInterceptor()的@Bean方法，它返回了一个MybatisPlusInterceptor类型的实例。
 *
 * MybatisPlusInterceptor是Mybatis-Plus框架提供的一个拦截器，它支持多种插件，并可以通过添加内置插件实现常见的功能，如分页。在这个@Bean方法中，首先创建了一个MybatisPlusInterceptor实例，然后向其中添加了一个PaginationInnerInterceptor插件（内置插件之一），并指定其数据库类型为MYSQL。
 *
 * 最后，该方法返回创建好的MybatisPlusInterceptor实例，以便在应用程序中使用
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
