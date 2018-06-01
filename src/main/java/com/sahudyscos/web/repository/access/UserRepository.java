package com.sahudyscos.web.repository.access;

import com.sahudyscos.web.entity.access.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
}