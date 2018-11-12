package com.ifood.controller;

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

    @GetMapping("/gettest")
    public  ResponseEntity<Object> getDishesById(@RequestParam("key") String key){
        RedisRepo<testClass> redis = new RedisRepo<testClass>();
        redis.startConnection();
        List<testClass> tesObj = redis.getListFromRedis(key, testClass.class);
        redis.close();
        ResponseEntity<Object> result = new ResponseEntity<>(tesObj, HttpStatus.ACCEPTED);
        return result;
    }
    class testClass{
        private int Id;
        private String Name;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            this.Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }
    }
}
