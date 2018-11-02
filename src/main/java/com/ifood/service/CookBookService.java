package com.ifood.service;

import com.ifood.domain.CookBookDishEntity;
import com.ifood.domain.CookBookEntity;
import com.ifood.repository.CookBookDishRepository;
import com.ifood.repository.CookBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import static com.ifood.config.Constants.*;

@Service
@Slf4j
public class CookBookService {
    @Autowired(required = true)
    private CookBookRepository cookBookRepository;
    @Autowired(required = true)
    private CookBookDishRepository cookBookDishRepository;

    public ResponseEntity<Object> createCookBook(CookBookEntity cookBook) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            if (!checkIsExist(cookBook) &&
                    cookBook.getName() != null) {
                cookBook.setCreateOn(new Timestamp(System.currentTimeMillis()));
                cookBook = cookBookRepository.save(cookBook);
                result = new ResponseEntity<>(cookBook, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> getCookbook(int id) {
        List<CookBookEntity> value = new ArrayList<>();
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            cookBookRepository.findById(id).ifPresent(value::add);
            if (!value.isEmpty()) {
                result = new ResponseEntity<>(value, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> getCookbookByUserId(String userId) {
        List<CookBookEntity> value = null;
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            value = cookBookRepository.findByUserId(userId);
            if (value != null && !value.isEmpty()) {
                for (CookBookEntity cb : value) {
                    cb.setDishOfCookBook(cookBookDishRepository.findByCookbookId(cb.getId()));
                }
                result = new ResponseEntity<>(value, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> updateCookBook(CookBookEntity cookBook) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            if (cookBook.getId() > 0) {
                cookBook = cookBookRepository.save(cookBook);
                result = new ResponseEntity<>(cookBook, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }


    public ResponseEntity<Object> removeCookbook(int id) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            cookBookRepository.deleteById(id);
            result = new ResponseEntity<>(SUCCESS, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {

            return result;
        }
    }

    private boolean checkIsExist(CookBookEntity cookBook) {
        return cookBookRepository.findByUserIdAndName(cookBook.getUserId(), cookBook.getName()) != null;
    }


    public ResponseEntity<Object> addDishToCookBook(List<CookBookDishEntity> cbDishList) {
        ResponseEntity<Object> result = null;
        try {
            for (CookBookDishEntity cbd : cbDishList) {
                if (cbd.getDishId() != null && cbd.getCookbookId() > 0)
                    cookBookDishRepository.save(cbd);
            }
            result = new ResponseEntity<>(SUCCESS, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage());
            result = new ResponseEntity<>("wrong dishId or CookbookId", HttpStatus.BAD_REQUEST);
        } finally {
            return result;
        }
    }

    public ResponseEntity<Object> removeDishOutCookBook(List<CookBookDishEntity> cbDishList) {
        ResponseEntity<Object> result = null;
        try {
            for (CookBookDishEntity cbd : cbDishList) {
                if (cbd.getId() > 0)
                    cookBookDishRepository.deleteById(cbd.getId());
            }
            result = new ResponseEntity<>(SUCCESS, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage());
            result = new ResponseEntity<>("wrong id", HttpStatus.BAD_REQUEST);
        } finally {
            return result;
        }
    }
}
