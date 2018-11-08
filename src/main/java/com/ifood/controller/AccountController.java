package com.ifood.controller;

import com.ifood.domain.UserEntity;
import com.ifood.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestValue(){
        return "Success";
    }

    @PutMapping("")
    public ResponseEntity<Object> createAccount(@RequestBody UserEntity newUser){
        return accountService.createUser(newUser);
    }

    @GetMapping("")
    public ResponseEntity<Object> getUserById(@RequestParam("userId") String userId){
        return accountService.getUserById(userId);
    }

    @PostMapping("/checklogin")
    public ResponseEntity<Object> checkLogin(@RequestBody UserEntity newUser){
        return accountService.checkLogin(newUser);
    }
    @PostMapping("")
    public ResponseEntity<Object> updateUser(@RequestBody UserEntity newUser){
        return accountService.updateUser(newUser);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> removeUser(@RequestParam("email") String email){
        return accountService.setRemove(email);
    }
}
