package com.example.dubboconsumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubboapi.Goods;
import com.example.dubboconsumer.po.User;
import com.example.dubboconsumer.service.test1;
import com.example.dubboprovider.Query;
import com.example.dubboprovider.queryGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 林世哲
 * @Data 2022/5/11 20:16
 * @Version 1.0
 */
@RestController
public class query {
    @Reference
    private com.example.dubboprovider.Query query;
    @Autowired
    private test1 test;

    @GetMapping("/query1")
    public String getUserGoods() {
        test.testUser();
        return "成功";
    }

    @GetMapping("/query2")
    @SentinelResource("text1")
    public String getUserGoods2( String name, Integer age){
        test.testUser();
        return "成功2"+name+age;
    }

}
