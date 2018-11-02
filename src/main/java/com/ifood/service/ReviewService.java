package com.ifood.service;

import com.ifood.domain.ReviewEntity;
import com.ifood.repository.ReviewRepository;
import com.ifood.util.EncryptionDecryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ifood.config.Constants.ERROR;
import static com.ifood.config.Constants.SUCCESS;

@Service
@Slf4j
public class ReviewService {
    @Autowired(required = true)
    private ReviewRepository reviewRepository;

    public ResponseEntity<Object> submitReviewByUser(String userId, String dishId){
        HttpHeaders responseHeaders = new HttpHeaders();
        ReviewEntity entity = new ReviewEntity();
        try {

        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(null);
        }
    }
}
