package com.ifood.controller;

import com.ifood.domain.CookBookDishEntity;
import com.ifood.domain.CookBookEntity;
import com.ifood.service.CookBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cookbook")
public class CookBookController {
    @Autowired
    private CookBookService cookBookService;

    @PutMapping("")
    public ResponseEntity<Object> createCookBook(@RequestBody CookBookEntity cookBook){
        return cookBookService.createCookBook(cookBook);
    }

    @GetMapping("")
    public ResponseEntity<Object> getCookBook(@RequestParam("id")int id ){
        return cookBookService.getCookbook(id);
    }
    @GetMapping("/user")
    public ResponseEntity<Object> getCookBook(@RequestParam("id")String userId ){
        return cookBookService.getCookbookByUserId(userId);
    }
    @PostMapping("")
    public ResponseEntity<Object> updateCookBook(@RequestBody CookBookEntity cookBook){
        return cookBookService.updateCookBook(cookBook);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteCookBook(@RequestParam("id")int id ){
        return cookBookService.removeCookbook(id);
    }
    @PutMapping("/dish")
    public ResponseEntity<Object> addDishToCookBook(@RequestBody List<CookBookDishEntity> cookBookDishs){
        return cookBookService.addDishToCookBook(cookBookDishs);
    }
    @DeleteMapping("/dish")
    public ResponseEntity<Object> deleteDishFromCookBook(@RequestBody List<CookBookDishEntity> listDish){
        return cookBookService.removeDishOutCookBook(listDish);
    }
}
