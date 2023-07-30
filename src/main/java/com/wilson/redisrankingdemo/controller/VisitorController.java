package com.wilson.redisrankingdemo.controller;

import com.wilson.redisrankingdemo.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname VisitorController
 * @Description TODO
 * @Date 2023/7/30 11:50 AM
 * @Author Wilson Chen
 */
@RestController
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @GetMapping("/")
    public String count() {
        visitorService.increment();
        return "Total Visitors: " + visitorService.getCount();
    }
}
