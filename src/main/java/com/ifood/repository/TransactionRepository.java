package com.ifood.repository;

import com.ifood.domain.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {
    List<TransactionEntity> findByUserId(String userId);
}
