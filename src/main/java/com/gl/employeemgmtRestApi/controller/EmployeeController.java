package com.gl.employeemgmtRestApi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemgmtRestApi.entity.Employee;
import com.gl.employeemgmtRestApi.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;

	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees() {
		return empservice.getAllEmployees();
	}

	@GetMapping("/getEmployeeById/{empId}")
	public Employee getEmployeeById(@PathVariable("empId") int empId) {
		return empservice.findById(empId);
	}

	@PostMapping("/addEmployee")
	public String addEmployeeDetails(@RequestBody Employee employees) {
		return empservice.addEmployeeDetails(employees);
	}

	@DeleteMapping("/deleteEmployeeById/{empId}")
	public String deleteEmployeeById(@PathVariable("empId") int empId) {
		return empservice.deleteById(empId);
	}

	@PutMapping("/updateEmployeeById/{empId}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return empservice.updateEmployee(employee);

	}

	@GetMapping("/searchEmployeeByName/{empName}")
	public List<Employee> searchEmployeeByName(@PathVariable("empName") String firstName) {
		return empservice.searchEmployeeByFirstName(firstName);

	}

	@GetMapping("/getSortedByEmployeeFirstName/{empFirstName}")
	public List<Employee> sortEmployeeByFirstName(@PathVariable("empFirstName") String firstName) {
		return empservice.getEmployeesSortedByFirstName(firstName);
	}

}
