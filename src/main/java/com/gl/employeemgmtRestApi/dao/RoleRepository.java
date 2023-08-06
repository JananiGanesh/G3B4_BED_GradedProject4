package com.gl.employeemgmtRestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeemgmtRestApi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
