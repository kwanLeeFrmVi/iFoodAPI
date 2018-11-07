package com.ifood.domain.model;

import com.ifood.domain.ReviewEntity;
import com.ifood.domain.UserEntity;

public class ReviewByUser {
    private UserEntity user;
    private ReviewEntity review;

    public ReviewByUser() {
    }

    public ReviewByUser(UserEntity user, ReviewEntity review) {
        this.user = user;
        this.review = review;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ReviewEntity getReview() {
        return review;
    }

    public void setReview(ReviewEntity review) {
        this.review = review;
    }
}
