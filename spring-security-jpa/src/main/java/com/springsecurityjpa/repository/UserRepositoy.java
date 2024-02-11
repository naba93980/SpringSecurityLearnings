package com.springsecurityjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurityjpa.models.User;

@Repository
public interface UserRepositoy extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
