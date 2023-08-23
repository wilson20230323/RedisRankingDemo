package com.wilson.redisrankingdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Classname CartService
 * @Description TODO
 * @Date 2023/7/30 12:25 PM
 * @Author Wilson Chen
 */
@Service
public class CartService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void addItem(String userId, String itemId, String quantity) {
        stringRedisTemplate.opsForHash().put("cart:" + userId, itemId, quantity);
    }

    public void removeItem(String userId, String itemId) {
        stringRedisTemplate.opsForHash().delete("cart:" + userId, itemId);
    }

    public Map<Object, Object> getItems(String userId) {
        return stringRedisTemplate.opsForHash().entries("cart:" + userId);
    }
}
