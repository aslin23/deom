package com.example.dubboconsumer.po;

/**
 * @author 林世哲
 * @Data 2022/5/10 20:18
 * @Version 1.0
 */

import com.example.dubboapi.Goods;

import java.io.Serializable;
import java.util.List;

/**
 * 用户类
 */
public class User implements Serializable {

    private String name;

    private List<Goods> goods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
