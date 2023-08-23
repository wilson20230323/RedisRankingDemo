package com.wilson.redisrankingdemo.controller;

import com.wilson.redisrankingdemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/online/{playerName}")
    public void playerOnline(@PathVariable String playerName) {
        playerService.playerOnline(playerName);
    }

    @PostMapping("/offline/{playerName}")
    public void playerOffline(@PathVariable String playerName) {
        playerService.playerOffline(playerName);
    }

    @GetMapping("/onlinePlayers")
    public Set<String> getOnlinePlayers() {
        return playerService.getOnlinePlayers();
    }
}
