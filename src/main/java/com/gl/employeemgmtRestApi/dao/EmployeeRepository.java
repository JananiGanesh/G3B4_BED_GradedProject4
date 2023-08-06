package com.gl.employeemgmtRestApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.employeemgmtRestApi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "SELECT * FROM employee e where e.emp_first_name LIKE %?1%", nativeQuery = true)
	List<Employee> searchEmployeeByFirstName(String firstName);

}
