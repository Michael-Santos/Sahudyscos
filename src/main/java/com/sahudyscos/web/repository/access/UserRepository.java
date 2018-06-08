package com.sahudyscos.web.repository.access;

import com.sahudyscos.web.entity.access.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User> {
	 User findByUsername(String username);
}