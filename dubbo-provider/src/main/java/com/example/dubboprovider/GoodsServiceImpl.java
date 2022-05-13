package com.example.dubboprovider;

/**
 * @author 林世哲
 * @Data 2022/5/10 20:14
 * @Version 1.0
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.dubboapi.Goods;
import com.example.dubboapi.GoodsService;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.RpcContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品信息服务实现-模拟返回商品列表
 */
// 注意需使用正确的包 org.apache.dubbo.config.annotation.Service
@Service(version = "${service.version}")
public class GoodsServiceImpl implements GoodsService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @SentinelResource(value = "getAllGoods",blockHandler = "stopUser")
    public List<Goods> getAllGoods() {
        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods("电脑", 10));
        goods.add(new Goods("手机", 20));
        goods.add(new Goods("书籍", 30));
        logger.info(RpcContext.getContext().getRemoteHost()+"正在调用服务..");
        return goods;
    }

    public List<Goods> stopUser(){
        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods("失败了", 10));
        return goods;
    }
}