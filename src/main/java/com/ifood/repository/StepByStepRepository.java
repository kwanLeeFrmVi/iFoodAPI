package com.ifood.repository;

import com.ifood.domain.StepByStepEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepByStepRepository extends CrudRepository<StepByStepEntity, String> {
    List<StepByStepEntity> findByDishId(String dishId);
}
