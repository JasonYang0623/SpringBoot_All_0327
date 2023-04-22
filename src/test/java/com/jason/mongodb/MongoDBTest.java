package com.jason.mongodb;

import com.jason.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Jason
 * @date 2023/4/11 14:17
 * @content
 */
@SpringBootTest
public class MongoDBTest {
    @Autowired
    private MongoTemplate template;

    @Test
    void setMongo(){
        User user = new User();
        user.setId(111);
        user.setUsername("test");
        user.setPassword("123456");
        user.setReal_name("test");
        User inserted= template.insert(user);
        System.out.println(inserted);
    }
}
