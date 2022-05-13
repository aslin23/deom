package com.example.dubboconsumer.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author 林世哲
 * @Data 2022/5/11 20:39
 * @Version 1.0
 */
@Service
public class test1 {
    @SentinelResource("test")
    public String testUser(){
        return "哈哈哈";
    }
}
