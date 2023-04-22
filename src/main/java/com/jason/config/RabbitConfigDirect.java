package com.jason.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jason
 * @date 2023/4/20 14:51
 * @content 初始化rabbit相关对象
 */
@Configuration
public class RabbitConfigDirect {
    //声明队列
    @Bean
    public Queue directQueue_1(){
        return new Queue("direct_queue_1");
    }
    @Bean
    public Queue directQueue_2(){
        return new Queue("direct_queue_2");
    }
    //声明交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }
    //声明绑定关系
    @Bean
    public Binding bindingDirect_1(){
        return BindingBuilder.bind(directQueue_1()).to(directExchange()).with("direct_1");//with是路由键
    }
    @Bean
    public Binding bindingDirect_2(){
        return BindingBuilder.bind(directQueue_2()).to(directExchange()).with("direct_2");
    }
}
