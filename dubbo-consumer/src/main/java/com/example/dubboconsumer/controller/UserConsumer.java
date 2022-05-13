package com.example.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubboapi.Goods;
import com.example.dubboapi.GoodsService;
import com.example.dubboconsumer.po.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 林世哲
 * @Data 2022/5/10 20:17
 * @Version 1.0
 */
@RestController
public class UserConsumer {

    @Reference(version= "${service.version}")
    private GoodsService goodsService;



    int i=0;
    @GetMapping("/userGoods1")
    //这里的参数用来测试热点参数限流
    public User getUserGoods( String name, Integer age) {

        //模拟异常 测试降级规则的异常比例
        User user = new User();
        // 通过GoodsService接口调用商品微服务
        try {
            List<Goods> goods = goodsService.getAllGoods();
            user.setName("jack");
            user.setGoods(goods);
            user.setName(name);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return user;
    }

    @GetMapping("/userGoods2")
    public User getUserGoods2() {
        User user = new User();
        // 通过GoodsService接口调用商品微服务
        try {
            List<Goods> goods = goodsService.getAllGoods();
            user.setName("jack");
            user.setGoods(goods);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return user;
    }

}
