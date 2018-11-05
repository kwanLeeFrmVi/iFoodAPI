package com.ifood.repository;

import com.ifood.domain.ReviewEntity;
import com.ifood.domain.UserEntity;
import com.ifood.domain.model.ReviewByUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity, String> {
    @Query("Select r as Review, u as User From ReviewEntity r join UserEntity u on r.userReview.id = u.id" +
            " where r.dishId = :dishId And r.delete = false")
    List<ReviewEntity> findReviewEntitiesByDishId (@Param("dishId") String dishId);
}
