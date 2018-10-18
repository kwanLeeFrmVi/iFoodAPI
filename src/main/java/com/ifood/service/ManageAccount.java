package com.ifood.service;

import com.ifood.domain.User;
import com.ifood.repository.UserAccountRepository;
import com.ifood.util.EncryptionDecryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

import static com.ifood.config.Constants.*;

@Service
@Slf4j
public class ManageAccount {
    @Autowired(required = true)
    private UserAccountRepository userAccountRepository;

    public ResponseEntity<Object> CreateUser(User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            if (!checkExistEmail(user.getEmail())) {
                String loginPass = EncryptionDecryption.encrypt(user.getPassword());
                user.setPassword(loginPass);
                userAccountRepository.save(user);
                responseHeaders.set(SUCCESS, "user create success");
            } else {
                responseHeaders.set(ERROR, "email already exists");
            }
        } catch (Exception e) {
            myLoger(e);
            responseHeaders.set(ERROR, "email already exists");
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(user);
        }
    }

    public ResponseEntity<Object> checkLogin(User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        User userData = null;
        try {
            userData = userAccountRepository.findByEmail(user.getEmail());
            if (userData != null && EncryptionDecryption.checkLogin(user.getPassword(), userData.getPassword())) {
                responseHeaders.set(SUCCESS, "user is valid");
            } else {
                responseHeaders.set(ERROR, "Wrong password or email");
            }
        } catch (Exception e) {
            myLoger(e);
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(userData);
        }
    }

    public boolean setRemove(String email) {
        boolean result = false;
        try {
            User user = userAccountRepository.findByEmail(email);
            if (user != null) {
                user.setDelete(true);
                userAccountRepository.save(user);
                result = true;
            }
        } catch (Exception e) {
            myLoger(e);
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> updateUser(User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Object> result;
        try {
            User old = userAccountRepository.findByEmail(user.getEmail());
            if (old != null && user.getPassword().equals(old.getPassword()) && user.getId() != null) {
                userAccountRepository.save(user);//cho nay can lam ham updateUser trong model
                responseHeaders.set(SUCCESS, "user update Success");
            } else {
                responseHeaders.set(ERROR, "Wrong password or email");
            }
        } catch (Exception e) {
            myLoger(e);
            responseHeaders.set(ERROR, e.getMessage());
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(user);
        }
    }

    private boolean checkExistEmail(String email) {
        //already have = true;
        return (userAccountRepository.findByEmail(email) != null);
    }

    private void myLoger(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
    }
}
