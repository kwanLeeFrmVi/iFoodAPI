package com.ifood.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "Review", schema = "dbo", catalog = "I_Food")
public class ReviewEntity {
    private int id;
    private String dishId;
    private String comment;
    private Double rate;
    private Timestamp reviewOn;
    private Boolean isDelete;

    private UserEntity userReview;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="UserId")
    public UserEntity getUserReview() {
        return userReview;
    }

    public void setUserReview(UserEntity userReview) {
        this.userReview = userReview;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DishId")
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "Rate")
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "ReviewOn")
    public Timestamp getReviewOn() {
        return reviewOn;
    }

    public void setReviewOn(Timestamp reviewOn) {
        this.reviewOn = reviewOn;
    }

    @Basic
    @Column(name = "IsDelete")
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
        ReviewEntity that = (ReviewEntity) o;
        return id == that.id &&
                Objects.equals(dishId, that.dishId) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(reviewOn, that.reviewOn) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishId, comment, rate, reviewOn, isDelete);
    }
}
