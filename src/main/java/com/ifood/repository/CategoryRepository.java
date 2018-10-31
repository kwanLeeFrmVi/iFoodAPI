package com.ifood.repository;

import com.ifood.domain.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, UUID> {
    List<CategoryEntity> findAll();
    Optional<CategoryEntity> findById(UUID categoryId);
}
