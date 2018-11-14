package com.ifood.repository;

import com.ifood.domain.DishEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DishRepository extends CrudRepository<DishEntity, String> {
    Optional<DishEntity> findById(String dishId);

    @Query("Select dish From DishEntity dish join CategoryDishEntity cd on dish.id = cd.dishId" +
            " join CategoryEntity category on category.id = cd.categoryId" +
            " Where category.id = :categoryId And dish.delete = false And dish.active = true Order by dish.rate desc")
    List<DishEntity> findByCategoryId (@Param("categoryId") String categoryId);

    @Query("SELECT dish FROM DishEntity dish WHERE dish.name like %:string% AND dish.delete = false ")
    List<DishEntity> findByString (@Param("string")String string);

    @Query("SELECT dish FROM DishEntity dish join CourseDishEntity cd on dish.id = cd.dishId" +
            " join CourseEntity course on cd.courseId = course.id" +
            " WHERE course.name like %:course% AND dish.id != :dishId  AND course.delete = false ")
    List<DishEntity> findByCourse (@Param("course") String course, @Param("dishId") String dishId);
}
