package com.ifood.controller;

import com.ifood.domain.CookBookDishEntity;
import com.ifood.domain.CookBookEntity;
import com.ifood.service.ManageCookBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cookbook")
public class CookBookController {
    @Autowired
    private ManageCookBookService manageCookBookService;

    @PutMapping("")
    public ResponseEntity<Object> createCookBook(@RequestBody CookBookEntity cookBook){
        return manageCookBookService.createCookBook(cookBook);
    }

    @GetMapping("")
    public ResponseEntity<Object> getCookBook(@RequestParam("id")int id ){
        return manageCookBookService.getCookbook(id);
    }
    @GetMapping("/user")
    public ResponseEntity<Object> getCookBook(@RequestParam("id")String userId ){
        return manageCookBookService.getCookbookByUserId(userId);
    }
    @PostMapping("")
    public ResponseEntity<Object> updateCookBook(@RequestBody CookBookEntity cookBook){
        return manageCookBookService.updateCookBook(cookBook);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteCookBook(@RequestParam("id")int id ){
        return manageCookBookService.removeCookbook(id);
    }
    @PutMapping("/dish")
    public ResponseEntity<Object> addDishToCookBook(@RequestBody List<CookBookDishEntity> cookBookDishs){
        return manageCookBookService.addDishToCookBook(cookBookDishs);
    }
}
