package com.jason.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jason
 * @date 2023/4/20 15:12
 * @content
 */
@SpringBootTest
public class AMQPTest_direct {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void sendMessage(String msg){
        rabbitTemplate.convertAndSend("directExchange","direct_1","这是我的第一个消息");
    }

}
