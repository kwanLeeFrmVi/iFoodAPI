package com.ifood.repository;

import com.ifood.domain.CourseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity, String> {
    @Query("Select dish From DishEntity dish join CourseDishEntity cd on dish.id = cd.dishId" +
            " join CourseEntity course on course.id = cd.courseId" +
            " where dish.id = 'dishId' and course.delete = false ")
    List<CourseEntity> findByDishId (@Param("dishId") String dishId);
}
