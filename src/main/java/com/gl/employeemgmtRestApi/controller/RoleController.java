package com.gl.employeemgmtRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemgmtRestApi.entity.Role;
import com.gl.employeemgmtRestApi.service.RoleServiceImpl;

@RestController
@RequestMapping("/api/employee/roles")
public class RoleController {

	@Autowired
	RoleServiceImpl roleService;

	@PostMapping("/addRoles")
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		Role savedRole = roleService.saveRole(role);
		return ResponseEntity.ok(savedRole);
	}
}
