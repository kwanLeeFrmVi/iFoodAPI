package com.ifood.controller;

import com.ifood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategories")
    public ResponseEntity<Object> getCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("")
    public ResponseEntity<Object> getCategoryById(String categoryId){
        return categoryService.getCategoryById(categoryId);
    }
}
