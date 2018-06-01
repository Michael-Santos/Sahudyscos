package com.sahudyscos.web.repository.access;

import com.sahudyscos.web.entity.access.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	 Role findByRole(String role);
}