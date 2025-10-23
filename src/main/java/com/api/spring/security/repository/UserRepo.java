package com.api.spring.security.repository;

import com.api.spring.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
