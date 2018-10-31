package com.ifood.repository;

import com.ifood.domain.CookBookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CookBookRepository  extends CrudRepository<CookBookEntity, UUID> {
    CookBookEntity findByUserIdAndName(UUID userId, String name);
}
