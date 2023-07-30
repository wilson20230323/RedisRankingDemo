package com.wilson.redisrankingdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Classname VisitorService
 * @Description 用于记录网站的访问次数
 * @Date 2023/7/30 11:43 AM
 * @Author Wilson Chen
 */
@Service
public class VisitorService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void increment() {
        stringRedisTemplate.opsForValue().increment("visitor_count");
    }

    public String getCount() {
        return stringRedisTemplate.opsForValue().get("visitor_count");
    }
}
