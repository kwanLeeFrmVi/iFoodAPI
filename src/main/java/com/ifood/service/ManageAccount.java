package com.ifood.service;

import com.ifood.domain.User;
import com.ifood.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManageAccount {

    @Autowired(required=true)
    private UserAccountRepository userAccountRepository;

    public String CreateUser(User user){
//        userAccountRepository.save(user);
        return "Success";
    }

    public String checkLogin(){
        return "";
    }
    public String updateUser(){
        return "";
    }
}
