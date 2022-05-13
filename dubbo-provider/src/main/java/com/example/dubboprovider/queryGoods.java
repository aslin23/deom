package com.example.dubboprovider;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author 林世哲
 * @Data 2022/5/11 20:14
 * @Version 1.0
 */
@Service
public class queryGoods implements Query{
    @SentinelResource("query")
    public void queryGood(){
        System.err.println("查询商品");
    }
}
