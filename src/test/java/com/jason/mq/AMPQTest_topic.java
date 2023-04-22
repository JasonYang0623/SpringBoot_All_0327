package com.jason.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jason
 * @date 2023/4/20 15:35
 * @content
 */
@SpringBootTest
public class AMPQTest_topic {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Test
    void sendMessage_topic(String id){
        System.out.println("待发送短信的订单已纳⼊处理队列（rabbitmq topic),id："+id);
        amqpTemplate.convertAndSend("topicExchange","topic.orders.id",id);
    }
}
