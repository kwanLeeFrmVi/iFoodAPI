package com.ifood.repository;

import com.ifood.domain.CookBookDishEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CookBookDishRepository extends CrudRepository<CookBookDishEntity, Integer> {
    @Query("Select cd, d From CookBookDishEntity cd join DishEntity  d on cd.dishInCookbook.id = d.id" +
            " Where cd.cookbookId = :cookbookId AND d.delete = false ")
    List<CookBookDishEntity> findDishByCookbookId(@Param("cookbookId") String cookbookId);

    @Transactional
    @Modifying
    @Query("Delete from CookBookDishEntity Where cookbookId = :cookbookId")
    void deleteByCookbookId(@Param("cookbookId") String cookbookId);
}
