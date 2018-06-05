package com.sahudyscos.web.repository.access;

import java.util.List;

import com.sahudyscos.web.entity.access.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	 Role findByRole(String role);
	 List<Role> findAllByRole(List<String> roles);
	 List<Role> findByRoleStartsWith(String role);
}