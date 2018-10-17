package com.ifood.repository;

import com.ifood.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserAccountRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
