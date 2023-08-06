package com.gl.employeemgmtRestApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.employeemgmtRestApi.dao.EmployeeRepository;
import com.gl.employeemgmtRestApi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);

	}

	@Override
	public String deleteById(int empid) {
		repository.deleteById(empid);
		return "Employee with id " + empid + " is deleted successfully";
	}

	@Override
	public Employee findById(int empid) {
		Optional<Employee> optemp = repository.findById(empid);
		if (optemp.isPresent()) {
			return optemp.get();
		}
		return null;

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// repository.
		int id = employee.getEmpId();

		Employee emp = repository.findById(id).get();
		emp.setEmpFirstName(employee.getEmpFirstName());
		emp.setEmpLastName(employee.getEmpLastName());
		emp.setEmpEmail(employee.getEmpEmail());
		return repository.save(emp);

	}

	@Override
	public List<Employee> searchEmployeeByFirstName(String firstName) {
		return repository.searchEmployeeByFirstName(firstName);

	}

	@Override
	public List<Employee> getEmployeesSortedByFirstName(String firstName) {

		return repository.findAll(Sort.by(firstName));

	}

	@Override
	public String addEmployeeDetails(Employee employees) {
		repository.save(employees);
		return "Employees Added Successfully";
	}
}
