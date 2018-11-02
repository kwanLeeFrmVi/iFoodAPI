package com.ifood.service;

import com.ifood.domain.UserEntity;
import com.ifood.repository.UserAccountRepository;
import com.ifood.util.EncryptionDecryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ifood.config.Constants.*;

@Service
@Slf4j
public class AccountService {
    @Autowired(required = true)
    private UserAccountRepository userAccountRepository;

    public ResponseEntity<Object> createUser(UserEntity user) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            if (!checkExistEmail(user.getEmail())) {
                String loginPass = EncryptionDecryption.encrypt(user.getPassword());
                user.setPassword(loginPass);
                user = userAccountRepository.save(user);
                result = new ResponseEntity<>(user, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            myLoger(e);
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> checkLogin(UserEntity user) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        UserEntity userData = null;
        try {
            userData = userAccountRepository.findByEmail(user.getEmail());
            if (userData != null && EncryptionDecryption.checkLogin(user.getPassword(), userData.getPassword())) {
                result = new ResponseEntity<>(user, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            myLoger(e);
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> setRemove(String email) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            UserEntity user = userAccountRepository.findByEmail(email);
            if (user != null) {
                user.setDelete(true);
                userAccountRepository.save(user);
                result = new ResponseEntity<>(user, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            myLoger(e);
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> updateUser(UserEntity user) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            UserEntity old = userAccountRepository.findByEmail(user.getEmail());
            if (old != null && user.getPassword().equals(old.getPassword()) && user.getId() != null) {
                old.updateUser(user);
                userAccountRepository.save(old);
                result = new ResponseEntity<>(user, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            myLoger(e);
        } finally {
            return result;
        }
    }
    //COn thieu update Password
    private boolean checkExistEmail(String email) {
        //already have = true;
        return (userAccountRepository.findByEmail(email) != null);
    }

    private void myLoger(Exception e) {
        log.error(e.getMessage());
    }

}
