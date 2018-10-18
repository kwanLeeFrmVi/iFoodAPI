package com.ifood.controller;

import com.ifood.domain.User;
import com.ifood.service.ManageAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.ifood.config.Constants.FAIL;
import static com.ifood.config.Constants.SUCCESS;

@RestController
@RequestMapping("/user")
public class AccountController {
    @Autowired
    private ManageAccount manageAccount;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestValue(){
        return "Success";
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createAccount(@RequestBody User newUser){
        return manageAccount.CreateUser(newUser);
    }

//    @GetMapping("/getbyemail")
//    public User getUserByEmail(@RequestParam("email") String email){
//        return manageAccount.getUserByEmail(email);
//    }

    @PostMapping("/checklogin")
    public ResponseEntity<Object> checkLogin(@RequestBody User newUser){
        return manageAccount.checkLogin(newUser);
    }
    @PostMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody User newUser){
        return manageAccount.updateUser(newUser);
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam("email") String email, HttpServletResponse response){
        String result = FAIL;
        if(manageAccount.setRemove(email)){
            response.addHeader(SUCCESS, "User has been set removed");
            result = SUCCESS;
        }else
            response.addHeader(FAIL, "remove fail, User may not exist");
        return result;
    }
}
