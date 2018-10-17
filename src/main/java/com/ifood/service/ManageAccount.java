package com.ifood.service;

import com.ifood.domain.User;
import com.ifood.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ManageAccount {

    @Autowired(required=true)
    private UserAccountRepository userAccountRepository;

    public String CreateUser(User user){
        user.setId(UUID.randomUUID());
        userAccountRepository.save(user);
        return "Success";
    }
    public User getUserByEmail(String email){
        try {
            return userAccountRepository.findByEmail(email);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }

    }
    public String checkLogin(){
        return "";
    }
    public String updateUser(){
        return "";
    }
}
