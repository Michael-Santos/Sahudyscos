package com.sahudyscos.web.repository.access;

import java.util.Optional;

import com.sahudyscos.web.entity.access.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {
	Optional<User> findById(Integer id);
	User findByUsername(String username);
}