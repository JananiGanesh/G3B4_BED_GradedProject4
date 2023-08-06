package com.gl.employeemgmtRestApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employeemgmtRestApi.dao.RoleRepository;
import com.gl.employeemgmtRestApi.dao.UserRepository;
import com.gl.employeemgmtRestApi.entity.Role;
import com.gl.employeemgmtRestApi.entity.User;
import com.gl.employeemgmtRestApi.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserDetailsServiceImpl() {
		super();
	}

	public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(user);

	}

	public User addUserWithRoles(User user) {

		if (userRepository.getUserByUsername(user.getUsername()) != null) {
			return null;
		}

		// Find the roles by their IDs and attach them to the user
		List<Role> roles = user.getRoles();
		List<Role> attachedRoles = new ArrayList<>();
		for (Role role : roles) {
			Role dbRole = roleRepository.findById(role.getId()).orElse(null);
			if (dbRole != null) {
				attachedRoles.add(dbRole);
			}
		}
		user.setRoles(attachedRoles);
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		User savedUser = userRepository.save(user);
		return savedUser;

	}

}
