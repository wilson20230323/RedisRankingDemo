package com.wilson.redisrankingdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlayerService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void playerOnline(String playerName) {
        stringRedisTemplate.opsForSet().add("onlinePlayers", playerName);
    }

    public void playerOffline(String playerName) {
        stringRedisTemplate.opsForSet().remove("onlinePlayers", playerName);
    }

    public Set<String> getOnlinePlayers() {
        return stringRedisTemplate.opsForSet().members("onlinePlayers");
    }
}
