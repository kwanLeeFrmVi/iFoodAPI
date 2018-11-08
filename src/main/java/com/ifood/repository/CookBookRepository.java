package com.ifood.repository;

import com.ifood.domain.CookBookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface CookBookRepository  extends CrudRepository<CookBookEntity, Integer> {
    CookBookEntity findByUserIdAndName(String userId, String name);
    List<CookBookEntity> findByUserId(String userId);
    @Transactional
    @Modifying
    void deleteByUserId(String userId);
}
