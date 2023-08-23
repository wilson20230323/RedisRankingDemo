package com.wilson.redisrankingdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MemoryController
 * @Description TODO
 * @Date 2023/8/21 1:36 PM
 * @Author Wilson Chen
 */
@RestController
public class MemoryController {
    private List<Person> people = new ArrayList<>();

    @GetMapping("/generate-objects")
    public ResponseEntity<String> generateObjects() {
        for (int i = 0; i < 100000; i++) {
            people.add(new Person("Name" + i, i));
        }

        // 故意使其中一些对象不可达
        if (people.size() > 50000) {
            people.subList(0, 50000).clear();
        }

        return ResponseEntity.ok("Objects generated and some are made unreachable!");
    }
}
