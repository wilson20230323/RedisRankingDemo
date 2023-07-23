package com.wilson.redisrankingdemo.controller;


import com.wilson.redisrankingdemo.service.RankingService;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @Classname RankingController
 * @Description TODO
 * @Date 2023/7/23 11:35 AM
 * @Author Wilson Chen
 */

@RestController
@RequestMapping("/ranking")
public class RankingController {
    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping("/{user}")
    public void addScore(@PathVariable String user, @RequestParam double score) {
        rankingService.addScore(user, score);
    }

    @GetMapping("/top/{rank}")
    public Set<ZSetOperations.TypedTuple<String>> getTopUsers(@PathVariable int rank) {
        return rankingService.getTopUsers(rank);
    }
}
