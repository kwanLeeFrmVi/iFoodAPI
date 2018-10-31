package com.ifood.controller;

import com.ifood.domain.CookBookEntity;
import com.ifood.service.ManageCookBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cookbook")
public class CookBookController {
    @Autowired
    private ManageCookBookService manageCookBookService;

    @PutMapping("")
    public ResponseEntity<Object> createAccount(@RequestBody CookBookEntity cookBook){
        return manageCookBookService.createCookBook(cookBook);
    }
}
