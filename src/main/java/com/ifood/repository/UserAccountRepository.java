package com.ifood.repository;

import com.ifood.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends CrudRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
    List<UserEntity> findByIdAndAddress(String id, String address);


}
