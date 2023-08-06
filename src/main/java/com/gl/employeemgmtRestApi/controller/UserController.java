package com.gl.employeemgmtRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemgmtRestApi.entity.User;
import com.gl.employeemgmtRestApi.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/employee/users")
public class UserController {

	@Autowired
	UserDetailsServiceImpl userDetail;

	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user, Authentication auth) {

		if (userDetail.addUserWithRoles(user) == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(userDetail.addUserWithRoles(user));

	}
}
