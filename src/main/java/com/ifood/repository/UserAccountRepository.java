package com.ifood.repository;

import com.ifood.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserAccountRepository extends CrudRepository<User, UUID> {
    User findByEmail(String email);
//    @Query("select name from User")
    List<User> findAll();

}
