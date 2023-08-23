package com.wilson.redisrankingdemo.controller;

import com.wilson.redisrankingdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{articleId}/comments")
    public void addComment(@PathVariable String articleId, @RequestParam String comment) {
        commentService.addComment(articleId, comment);
    }

    @GetMapping("/{articleId}/comments")
    public List<String> getComments(@PathVariable String articleId) {
        return commentService.getComments(articleId);
    }
}
