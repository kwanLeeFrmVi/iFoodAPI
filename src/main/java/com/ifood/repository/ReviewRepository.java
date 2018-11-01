package com.ifood.repository;

import com.ifood.domain.ReviewEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<ReviewEntity, String> {
    List<ReviewEntity> findByDishIdAndDelete (String dishId, boolean delete);
}
