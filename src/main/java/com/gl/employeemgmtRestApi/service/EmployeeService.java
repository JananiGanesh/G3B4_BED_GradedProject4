package com.gl.employeemgmtRestApi.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.gl.employeemgmtRestApi.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	String deleteById(int empid);

	Employee findById(int empid);

	Employee updateEmployee(Employee employee);

	List<Employee> searchEmployeeByFirstName(String firstName);

	List<Employee> getEmployeesSortedByFirstName(String firstName);

	String addEmployeeDetails(Employee employees);
}
