package com.ifood.repository.generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<T> extends CrudRepository<T, UUID> {

    Optional<T> findById(UUID id);
}
