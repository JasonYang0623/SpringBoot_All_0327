package com.jason.Redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author Jason
 * @date 2023/4/10 14:20
 * @content
 */
@SpringBootTest
public class RedisTest {


    //  自动装配  StringRedisTemplate  实例对象
    @Autowired
    private  StringRedisTemplate  redisTemplate;

    //  设置测试方法  setValue
    @Test
    void  setValue()  throws  Exception  {
        //  获取  StringRedisTemplate  实例的  ValueOperations  对象，用于对  Redis  中键对应的值的操作
        ValueOperations  ops  =  redisTemplate.opsForValue();
        //  设置  Redis  中  key  为    jason    的值为    jason
        ops.set("jason","jason");
    }

    //  设置测试方法  getValue
    @Test
    void  getValue()  throws  Exception  {
        //  获取  StringRedisTemplate  实例的  ValueOperations  对象，用于对  Redis  中键对应的值的操作
        ValueOperations  ops  =  redisTemplate.opsForValue();
        //  输出  Redis  中  key  为    jason    对应的值
        System.out.println(ops.get("jason"));
    }
}
