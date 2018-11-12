package com.ifood.repository;

import com.ifood.domain.ShoppingListEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingListEntity, String> {
    @Query("Select dish.name as dishName, ingredient.name as ingredientName, user.name as userName, shopping.amount as amount" +
            " From ShoppingListEntity shopping join DishEntity dish on shopping.dishId = dish.id " +
            " join IngredientEntity ingredient on shopping.ingredientId = ingredient.id " +
            " join UserEntity user on shopping.userId = user.id" +
            " Where shopping.transactionId = :transactionId")
    List<Object> findByTransactionId(@Param("transactionId") String transactionId);
}
