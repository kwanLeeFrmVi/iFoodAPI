package com.ifood.repository;

import com.ifood.domain.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity, String> {
    List<ReviewEntity> findByDishIdAndDelete (String dishId, boolean delete);
}
