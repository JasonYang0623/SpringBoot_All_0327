package com.jason.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author Jason
 * @date 2023/4/20 15:29
 * @content
 */
@Configuration
public class RabbitConfigTopic {
    @Bean
    public Queue topicQueue(){
        return new Queue("topic_queue");
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue("topic_queue2");
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }
    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }
    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.orders.*");
    }
}
