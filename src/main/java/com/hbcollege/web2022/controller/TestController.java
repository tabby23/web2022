package com.hbcollege.web2022.controller;

import com.hbcollege.web2022.entity.Goods;
import com.hbcollege.web2022.entity.Order;
import com.hbcollege.web2022.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class TestController {

    @GetMapping("/user/{id}")
    public Map<String, Object> user(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        if(id == 1) {
            result.put("username", "jack");
            result.put("password", 123);
        }
        else {
            result.put("username", "jerry");
            result.put("password", 321);
        }
        return result;
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Object> delUser(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", true);
        result.put("id", id);
        return result;
    }

    @PutMapping("/user/{id}")
    public Map<String, Object> updateUser(@PathVariable int id, @RequestBody Map<String, Object>user) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", true);
        result.put("id", id);
        result.put("name", user.get("name"));
        result.put("age", user.get("age"));
        return result;
    }

    @GetMapping("/goods")
    public List<Goods> getGoods() {
        List<Goods> result = new ArrayList<>();
        Goods goods;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            goods = new Goods();
            goods.setName("测试商品" + (i + 1));
            goods.setPrice(Math.round(random.nextFloat()*100)/100f + random.nextInt(1000));
            goods.setPic("https://picsum.photos/360/460?random=" + random.nextInt(1000));
            result.add(goods);
        }
        return result;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        if("jack".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            result.put("result", true);
            result.put("user", user);
        }
        else {
            result.put("result", false);
        }
        return result;
    }

    @GetMapping("/orders/{type}")
    public List<Order> getOrders(@PathVariable int type) {
        /**
         * type 1：待支付
         * type 2：待发货
         * type 3：待收货
         */
        List<Order> result = new ArrayList<>();
        Order order;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            order = new Order();
            order.setPrice(Math.round(random.nextFloat()*100)/100f + random.nextInt(1000));
            order.setPic("https://picsum.photos/360/460?random=" + random.nextInt(1000));
            switch (type) {
                case 1:
                    order.setName("待支付商品" + (i + 1));
                    order.setPay(false);
                    order.setSend(false);
                    order.setReceive(false);
                    break;
                case 2:
                    order.setName("待发货商品" + (i + 1));
                    order.setPay(true);
                    order.setSend(false);
                    order.setReceive(false);
                    break;
                case 3:
                    order.setName("待收货商品" + (i + 1));
                    order.setPay(true);
                    order.setSend(true);
                    order.setReceive(false);
                    break;
            }
            result.add(order);
        }
        return result;
    }
}
