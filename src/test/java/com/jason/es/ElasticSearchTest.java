package com.jason.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jason
 * @date 2023/4/17 8:56
 * @content
 */
@SpringBootTest
public class ElasticSearchTest {
    @Autowired
    private RestHighLevelClient client;

    @Test
    public void testcreate() throws Exception {
        HttpHost host=HttpHost.create("http://localhost:9200");
        RestClientBuilder builder= RestClient.builder(host);
        client= new RestHighLevelClient(builder);
        //增删改查操作

        client.close();
    }
}
