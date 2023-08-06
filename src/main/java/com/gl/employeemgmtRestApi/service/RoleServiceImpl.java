package com.gl.employeemgmtRestApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeemgmtRestApi.dao.RoleRepository;
import com.gl.employeemgmtRestApi.entity.Role;

@Service
public class RoleServiceImpl {

	@Autowired
	RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

}
