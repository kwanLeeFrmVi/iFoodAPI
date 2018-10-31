package com.ifood.repository;

import com.ifood.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserAccountRepository extends CrudRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);
    List<UserEntity> findByIdAndAddress(UUID id, String address);


}
