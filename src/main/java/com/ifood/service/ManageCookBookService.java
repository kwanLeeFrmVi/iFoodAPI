package com.ifood.service;

import com.ifood.domain.CookBookEntity;
import com.ifood.repository.CookBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ifood.config.Constants.ERROR;
import static com.ifood.config.Constants.SUCCESS;

@Service
@Slf4j
public class ManageCookBookService {
    @Autowired(required = true)
    private CookBookRepository cookBookRepository;

    public ResponseEntity<Object> CreateCookBook(CookBookEntity cookBook){
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            if( !checkIsExist(cookBook) &&
                cookBook.getName()!=null){
                cookBookRepository.save(cookBook);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    private boolean checkIsExist(CookBookEntity cookBook){
        return  cookBookRepository.findByUserIdAndName(cookBook.getUserId(),cookBook.getName()) != null;
    }
}
