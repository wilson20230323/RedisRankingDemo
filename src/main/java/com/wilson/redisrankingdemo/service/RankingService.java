package com.wilson.redisrankingdemo.service;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Classname RankingService
 * @Description 服务类来处理排行榜相关的操作。这个服务类将使用RedisTemplate来操作Redis中的数据。
 * @Date 2023/7/23 11:24 AM
 * @Author Wilson Chen
 */
@Service
public class RankingService {
    private final RedisTemplate<String, String> redisTemplate;
    private ZSetOperations<String, String> zSetOperations;

    public RankingService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.zSetOperations = this.redisTemplate.opsForZSet();
    }

    public void addScore(String user, double score) {
        zSetOperations.incrementScore("Ranking", user, score);
    }

    public Set<ZSetOperations.TypedTuple<String>> getTopUsers(int topRank) {
        return zSetOperations.reverseRangeWithScores("Ranking", 0, topRank - 1);
    }
}
