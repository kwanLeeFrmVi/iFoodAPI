package com.ifood.controller;

import com.ifood.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired(required = true)
    private ReviewService reviewService;

    @PostMapping("")
    public ResponseEntity<Object> submitReviewByUser(@RequestBody Map<String, String> json){
        return reviewService.submitReviewByUser(json.get("userId"), json.get("dishId"),
                json.get("comment"), Double.parseDouble(json.get("rate")));
    }
}
