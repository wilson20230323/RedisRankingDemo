package com.wilson.redisrankingdemo.controller;

import com.wilson.redisrankingdemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Classname CartController
 * @Description TODO
 * @Date 2023/7/30 12:34 PM
 * @Author Wilson Chen
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}")
    public void addItem(@PathVariable String userId, @RequestParam String itemId, @RequestParam String quantity) {
        cartService.addItem(userId, itemId, quantity);
    }

    @DeleteMapping("/{userId}")
    public void removeItem(@PathVariable String userId, @RequestParam String itemId) {
        cartService.removeItem(userId, itemId);
    }

    @GetMapping("/{userId}")
    public Map<Object, Object> getItems(@PathVariable String userId) {
        return cartService.getItems(userId);
    }
}
