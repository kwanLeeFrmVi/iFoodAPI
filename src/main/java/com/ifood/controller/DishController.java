package com.ifood.controller;

import com.ifood.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService dishService;

//    @GetMapping("/")
//    public ResponseEntity<Object> getDishesByCategoryId(@RequestBody String categoryId){
//        return dishService.getDishesByCategoryId(categoryId);
//    }

    @GetMapping("/String")
    public ResponseEntity<Object> getDishesByString(@RequestBody String string){
        return dishService.getDishesByString(string);
    }

    @GetMapping("/Courses")
    public ResponseEntity<Object> getDishesByCourses (@RequestBody List<String> courses){
        return dishService.getDishesByCourses(courses);
    }
}
