package com.ifood.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Review {
    private int id;
    private UUID dishId;
    private UUID userId;
    private String comment;
    private Double rate;
    private Timestamp reviewOn;
    private Boolean isDelete;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DishId", nullable = false)
    public UUID getDishId() {
        return dishId;
    }

    public void setDishId(UUID dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "UserId", nullable = true)
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Comment", nullable = true, length = 2147483647)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "Rate", nullable = true, precision = 0)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "ReviewOn", nullable = true)
    public Timestamp getReviewOn() {
        return reviewOn;
    }

    public void setReviewOn(Timestamp reviewOn) {
        this.reviewOn = reviewOn;
    }

    @Basic
    @Column(name = "IsDelete", nullable = true)
    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                Objects.equals(dishId, review.dishId) &&
                Objects.equals(userId, review.userId) &&
                Objects.equals(comment, review.comment) &&
                Objects.equals(rate, review.rate) &&
                Objects.equals(reviewOn, review.reviewOn) &&
                Objects.equals(isDelete, review.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishId, userId, comment, rate, reviewOn, isDelete);
    }
}
