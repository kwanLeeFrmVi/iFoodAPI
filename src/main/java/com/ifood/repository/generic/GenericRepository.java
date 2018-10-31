package com.ifood.repository.generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


@NoRepositoryBean
public interface GenericRepository<T> extends CrudRepository<T, String> {

    Optional<T> findById(String id);
}
