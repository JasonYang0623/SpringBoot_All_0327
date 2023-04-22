package com.jason.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Jason
 * @date 2023/4/20 15:04
 * @content
 */
@Component
public class AMQP_direct {


    @RabbitListener(queues = "direct_queue_1")
    public void receive(String msg){
        System.out.println("接收到信息："+msg);
    }

}
