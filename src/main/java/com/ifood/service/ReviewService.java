package com.ifood.service;

import com.ifood.domain.ReviewEntity;
import com.ifood.domain.UserEntity;
import com.ifood.repository.ReviewRepository;
import com.ifood.repository.UserAccountRepository;
import com.ifood.util.EncryptionDecryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

import static com.ifood.config.Constants.ERROR;
import static com.ifood.config.Constants.SUCCESS;

@Service
@Slf4j
public class ReviewService {
    @Autowired(required = true)
    private ReviewRepository reviewRepository;
    @Autowired(required = true)
    private UserAccountRepository userAccountRepository;

    public ResponseEntity<Object> submitReviewByUser(String userId, String dishId, String comment, double rate){
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        ReviewEntity reviewEntity = new ReviewEntity();
        Optional<UserEntity> userEntity = userAccountRepository.findById(userId);
        reviewEntity.setUserReview(userEntity.get());
        reviewEntity.setDishId(dishId);
        reviewEntity.setComment(comment);
        reviewEntity.setRate(rate);
        reviewEntity.setDelete(false);
        reviewEntity.setReviewOn(new Timestamp(System.currentTimeMillis()));
        try {
            reviewEntity = reviewRepository.save(reviewEntity);
            result = new ResponseEntity<>(reviewEntity, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }
}
