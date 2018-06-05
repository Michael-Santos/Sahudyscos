package com.sahudyscos.web.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.sahudyscos.web.entity.access.Role;
import com.sahudyscos.web.entity.access.User;
import com.sahudyscos.web.repository.access.RoleRepository;
import com.sahudyscos.web.repository.access.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        /* Uncomment to create admins
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        */
		userRepository.save(user);
	}

	@Override
	public void saveUserAndRoles(User user, List<Role> roles) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(roles));
		userRepository.save(user);
	}

}