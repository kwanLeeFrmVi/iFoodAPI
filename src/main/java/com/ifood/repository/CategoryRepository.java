package com.ifood.repository;

import com.ifood.domain.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, String> {
    List<CategoryEntity> findAll();
    Optional<CategoryEntity> findById(String categoryId);
}
