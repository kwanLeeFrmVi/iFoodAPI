package com.ifood.controller;

import com.ifood.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/getByCategory")
    public ResponseEntity<Object> getDishesByCategoryId(String categoryId){
        return dishService.getDishesByCategoryId(categoryId);
    }

    @GetMapping("/getByString")
    public ResponseEntity<Object> getDishesByString(@RequestBody String string){
        return dishService.getDishesByString(string);
    }

    @PostMapping("/getByCourses")
    public ResponseEntity<Object> getDishesByCourses (@RequestBody List<String> courses){
        return dishService.getDishesByCourses(courses);
    }
}
