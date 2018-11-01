package com.ifood.service;

import com.ifood.domain.CookBookDishEntity;
import com.ifood.domain.CookBookEntity;
import com.ifood.repository.CookBookDishRepository;
import com.ifood.repository.CookBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import static com.ifood.config.Constants.*;

@Service
@Slf4j
public class ManageCookBookService {
    @Autowired(required = true)
    private CookBookRepository cookBookRepository;
    @Autowired(required = true)
    private CookBookDishRepository cookBookDishRepository;

    public ResponseEntity<Object> createCookBook(CookBookEntity cookBook) {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            if (!checkIsExist(cookBook) &&
                    cookBook.getName() != null) {
                cookBook.setCreateOn(new Timestamp(System.currentTimeMillis()));
                cookBook = cookBookRepository.save(cookBook);
                responseHeaders.set(SUCCESS, "cookbook create success");
            } else {
                responseHeaders.set(ERROR, "cookbook already exists or invalid");
            }
        } catch (Exception e) {
            cookBook = null;
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "Create error, invalid usserId");
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(cookBook);
        }
    }

    public ResponseEntity<Object> getCookbook(int id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        List<CookBookEntity> value = new ArrayList<>();
        try {
            cookBookRepository.findById(id).ifPresent(value::add);
            if (value.isEmpty()) {
                responseHeaders.set(ERROR, "cookbook id not exists ");
            } else {
                responseHeaders.set(SUCCESS, "cookbook get success ");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "get error");
        } finally {

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(value.get(0));
        }
    }

    public ResponseEntity<Object> getCookbookByUserId(String userId) {
        HttpHeaders responseHeaders = new HttpHeaders();
        List<CookBookEntity> value = null;
        try {
            value = cookBookRepository.findByUserId(userId);
            if (value == null || value.isEmpty()) {
                responseHeaders.set(ERROR, "cookbook id not exists ");
            } else {
                responseHeaders.set(SUCCESS, "cookbook get success ");
                for (CookBookEntity cb : value) {
                    cb.setDishOfCookBook(cookBookDishRepository.findByCookbookId(cb.getId()));
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "get error");
        } finally {

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(value);
        }
    }

    public ResponseEntity<Object> updateCookBook(CookBookEntity cookBook) {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            if (cookBook.getId() > 0) {
                cookBook = cookBookRepository.save(cookBook);
                responseHeaders.set(SUCCESS, "cookbook update success");
            } else {
                responseHeaders.set(ERROR, "cookbook id invalid");
            }
        } catch (Exception e) {
            cookBook = null;
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "update error");
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(cookBook);
        }
    }


    public ResponseEntity<Object> removeCookbook(int id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            cookBookRepository.deleteById(id);
            responseHeaders.set(SUCCESS, "cookbook remove success");
        } catch (Exception e) {
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "remove error");
        } finally {

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(SUCCESS);
        }
    }

    private boolean checkIsExist(CookBookEntity cookBook) {
        return cookBookRepository.findByUserIdAndName(cookBook.getUserId(), cookBook.getName()) != null;
    }


    public ResponseEntity<Object> addDishToCookBook(List<CookBookDishEntity> cbDishList) {
        HttpHeaders responseHeaders = new HttpHeaders();

        try {
                for (CookBookDishEntity cbd : cbDishList){
                    if(cbd.getDishId()!=null && cbd.getCookbookId()>0)
                        cookBookDishRepository.save(cbd);
                }
        } catch (Exception e) {
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "remove error");
        } finally {

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(SUCCESS);
        }
    }
}
