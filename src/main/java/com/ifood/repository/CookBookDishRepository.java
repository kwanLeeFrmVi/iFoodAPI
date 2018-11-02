package com.ifood.repository;

import com.ifood.domain.CookBookDishEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CookBookDishRepository extends CrudRepository<CookBookDishEntity, Integer> {
    List<CookBookDishEntity> findByCookbookId(String cookbookId);
}
