package com.example.dubboconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author 林世哲
 * @Data 2022/5/12 19:51
 * @Version 1.0
 */
@RestController
@Slf4j
public class AuthController {
    @RequestMapping("/auth1")
    public String auth1(String serviceName){
        log.info("应用:{},访问接口",serviceName);
        return "auth1"+serviceName;
    }
}
