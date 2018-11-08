package com.ifood.controller;

import com.ifood.domain.DishEntity;
import com.ifood.repository.RedisRepo;
import com.ifood.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("")
    public ResponseEntity<Object> getDishDetailById(@RequestParam String id){
        return dishService.getDishesById(id);
    }

    @GetMapping("/getByCategory")
    public ResponseEntity<Object> getDishesByCategoryId(@RequestParam String categoryId){
        return dishService.getDishesByCategoryId(categoryId);
    }

    @GetMapping("/getByString")
    public ResponseEntity<Object> getDishesByString(String string){
        return dishService.getDishesByString(string);
    }

    @PostMapping("/getByCourses")
    public ResponseEntity<Object> getDishesByCourses (@RequestBody List<String> courses, String dishId){
        return dishService.getDishesByCourses(courses, dishId);
    }

    @GetMapping("/getredish")
    public  ResponseEntity<Object> getDishesById(@RequestParam String id){
        RedisRepo<DishEntity> redis = new RedisRepo<DishEntity>();
        redis.startConnection();
        DishEntity dish = redis.getFromRedis("dish");
        ResponseEntity<Object> result = new ResponseEntity<>(dish, HttpStatus.ACCEPTED);
        return result;
    }
}
