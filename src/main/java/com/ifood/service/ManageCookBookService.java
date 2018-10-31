package com.ifood.service;

import com.ifood.domain.CookBookEntity;
import com.ifood.repository.CookBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


import static com.ifood.config.Constants.*;

@Service
@Slf4j
public class ManageCookBookService {
    @Autowired(required = true)
    private CookBookRepository cookBookRepository;

    public ResponseEntity<Object> createCookBook(CookBookEntity cookBook){
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            if( !checkIsExist(cookBook) &&
                cookBook.getName()!=null){
                cookBook = cookBookRepository.save(cookBook);
                responseHeaders.set(SUCCESS, "cookbook create success");
            }else {
                responseHeaders.set(ERROR, "cookbook already exists or invalid");
            }
        }catch (Exception e){
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "Create error");
        }finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(cookBook);
        }
    }

    public ResponseEntity<Object> getCookbook(String id){
        HttpHeaders responseHeaders = new HttpHeaders();
        String String = id;
        List<CookBookEntity> value = new ArrayList<>();
        try {
           cookBookRepository.findById(String).ifPresent(value::add);
           if(value.isEmpty()){
               responseHeaders.set(ERROR, "cookbook id not exists ");
           }else {
               responseHeaders.set(SUCCESS, "cookbook get success ");
           }
        }catch (Exception e){
            log.error(e.getMessage());
            responseHeaders.set(ERROR, "get error");
        }finally {

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(value);
        }
    }

    private boolean checkIsExist(CookBookEntity cookBook){
        return  cookBookRepository.findByUserIdAndName(cookBook.getUserId(),cookBook.getName()) != null;
    }

}
