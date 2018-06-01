package com.sahudyscos.web.service;

import com.sahudyscos.web.entity.access.User;

public interface UserService {
	public User findUserByUsername(String username);
	public void saveUser(User user);
}