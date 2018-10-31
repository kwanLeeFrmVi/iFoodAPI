package com.ifood.repository;

import com.ifood.domain.CookBookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CookBookRepository  extends CrudRepository<CookBookEntity, String> {
    CookBookEntity findByUserIdAndName(String userId, String name);
}
