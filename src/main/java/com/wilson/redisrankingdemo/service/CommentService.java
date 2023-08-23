package com.wilson.redisrankingdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void addComment(String articleId, String comment) {
        stringRedisTemplate.opsForList().rightPush("comments:" + articleId, comment);
    }

    public List<String> getComments(String articleId) {
        return stringRedisTemplate.opsForList().range("comments:" + articleId, 0, -1);
    }
}
