package com.ifood.service;

import com.ifood.domain.CategoryEntity;
import com.ifood.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ifood.config.Constants.FAIL;
import static com.ifood.config.Constants.SUCCESS;

@Service
@Slf4j
public class CategoryService {
    @Autowired(required = true)
    private CategoryRepository categoryRepository;

    public ResponseEntity<Object> getAllCategories(){
        HttpHeaders responseHeaders = new HttpHeaders();
        List<CategoryEntity> categories = new ArrayList<>();
        try {
            categories = categoryRepository.findAll();
            responseHeaders.set(SUCCESS, "get categories success");
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(categories);
        }
    }

    public ResponseEntity<Object> getCategoryById (String categoryId){
        HttpHeaders responseHeaders = new HttpHeaders();
        Optional<CategoryEntity> category = null;
        try {
            category = categoryRepository.findById(categoryId);
            if (category.isPresent()){
                responseHeaders.set(SUCCESS, "get category success");
            } else {
                responseHeaders.set(FAIL, "category is not exist");
            }

        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(category);
        }
    }
}
