package com.ifood.controller;

import com.ifood.domain.UserEntity;
import com.ifood.service.ManageAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.ifood.config.Constants.FAIL;
import static com.ifood.config.Constants.SUCCESS;

@RestController
@RequestMapping("/api/user")
public class AccountController {
    @Autowired
    private ManageAccountService manageAccountService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestValue(){
        return "Success";
    }

    @PutMapping("")
    public ResponseEntity<Object> createAccount(@RequestBody UserEntity newUser){
        return manageAccountService.createUser(newUser);
    }

//    @GetMapping("/getbyemail")
//    public User getUserByEmail(@RequestParam("email") String email){
//        return manageAccount.getUserByEmail(email);
//    }

    @PostMapping("/checklogin")
    public ResponseEntity<Object> checkLogin(@RequestBody UserEntity newUser){
        return manageAccountService.checkLogin(newUser);
    }
    @PostMapping("")
    public ResponseEntity<Object> updateUser(@RequestBody UserEntity newUser){
        return manageAccountService.updateUser(newUser);
    }

    @DeleteMapping("")
    public String removeUser(@RequestParam("email") String email, HttpServletResponse response){
        String result = FAIL;
        if(manageAccountService.setRemove(email)){
            response.addHeader(SUCCESS, "User has been set removed");
            result = SUCCESS;
        }else
            response.addHeader(FAIL, "remove fail, User may not exist");
        return result;
    }
}
