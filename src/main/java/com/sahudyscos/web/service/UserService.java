package com.sahudyscos.web.service;

import java.util.List;

import com.sahudyscos.web.entity.access.Role;
import com.sahudyscos.web.entity.access.User;

public interface UserService {
	public User findUserByUsername(String username);
	public void saveUser(User user);
	public void saveUserAndRoles(User user, List<Role> roles);
}