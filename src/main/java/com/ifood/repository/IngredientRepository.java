package com.ifood.repository;

import com.ifood.domain.IngredientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity, UUID> {
    @Query("SELECT ingredient FROM DishEntity dish join DishIngredientEntity di on dish.id = di.dishId" +
            " join IngredientEntity ingredient on di.ingredientId = ingredient.id" +
            " WHERE dish.id = 'dishId' AND ingredient.delete = false")
    List<IngredientEntity> findByDishId (@Param("dishId") UUID dishId);
}
