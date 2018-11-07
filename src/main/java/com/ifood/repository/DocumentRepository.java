package com.ifood.repository;

import com.ifood.domain.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends CrudRepository<DocumentEntity, String> {
    List<DocumentEntity> findByObjectIdAndDelete (String objectId, boolean delete);
}
