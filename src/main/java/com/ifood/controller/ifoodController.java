package com.ifood.controller;

import com.ifood.domain.User;
import com.ifood.service.ManageAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ifoodController {
    @Autowired
    private ManageAccount manageAccount;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestValue(){
        return "Success";
    }

    @PostMapping("/create")
    public String createAccount(@RequestBody User newUser){
        manageAccount.CreateUser(newUser);
        return "Success";
    }

}
