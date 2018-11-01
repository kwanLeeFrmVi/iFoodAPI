package com.ifood.service;

import com.ifood.domain.CourseEntity;
import com.ifood.domain.DishEntity;
import com.ifood.domain.IngredientEntity;
import com.ifood.domain.ReviewEntity;
import com.ifood.repository.CourseRepository;
import com.ifood.repository.DishRepository;
import com.ifood.repository.IngredientRepository;
import com.ifood.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.ifood.config.Constants.SUCCESS;

@Service
@Slf4j
public class DishService {
    @Autowired(required = true)
    private DishRepository dishRepository;
    @Autowired(required = true)
    private IngredientRepository ingredientRepository;
    @Autowired(required = true)
    private ReviewRepository reviewRepository;
    @Autowired(required = true)
    private CourseRepository courseRepository;

    public ResponseEntity<Object> getDishesById (String dishId){
        HttpHeaders responseHeaders = new HttpHeaders();
        Optional<DishEntity> dishEntity = null;
        DishEntity dish = null;
        try {
            dishEntity = dishRepository.findById(dishId);
            dish = dishEntity.get();

            //Courses
            List<CourseEntity> courses = courseRepository.findByDishId(dish.getId());
            dish.setCourses(courses);

            //Ingredients
            List<IngredientEntity> ingredients = ingredientRepository.findByDishId(dish.getId());
            dish.setIngredients(ingredients);

            //Reviews
            List<ReviewEntity> reviews = reviewRepository.findByDishIdAndDelete(dish.getId(), false);
            dish.setReviewes(reviews);

            //Related Dishes
            /*String firstCourse = dish.getCourses().get(0).getName();
            List<DishEntity> relatedDishes = dishRepository.findByCourse(firstCourse);
            dish.setRelatedDishes(relatedDishes);*/

            responseHeaders.set(SUCCESS, "get dishes success");
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(dish);
        }
    }

    public ResponseEntity<Object> getDishesByCategoryId(String categoryId){
        HttpHeaders responseHeaders = new HttpHeaders();
       List<DishEntity> dishes = new ArrayList<>();
       try {
            dishes = dishRepository.findByCategoryId(categoryId);
           responseHeaders.set(SUCCESS, "get dishes success");
       } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
       } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(dishes);
       }
    }

    public ResponseEntity<Object> getDishesByString(String string){
        HttpHeaders responseHeaders = new HttpHeaders();
        List<DishEntity> dishes = new ArrayList<>();
        try {
            dishes = dishRepository.findByString(string);
            responseHeaders.set(SUCCESS, "get dishes success");
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(dishes);
        }
    }

    public ResponseEntity<Object> getDishesByCourses (List<String> courses){
        HttpHeaders responseHeaders = new HttpHeaders();
        List<DishEntity> dishes = new ArrayList<>();
        try {
            for (String course : courses){
                List<DishEntity> dishEntities = dishRepository.findByCourse(course);
                dishes.addAll(dishEntities);
            }
            responseHeaders.set(SUCCESS, "get dishes success");
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(dishes);
        }
    }


}
