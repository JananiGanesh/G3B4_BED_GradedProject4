package com.gl.employeemgmtRestApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "emp_first_name")
	private String empFirstName;
	@Column(name = "emp_last_name")
	private String empLastName;
	@Column(name = "emp_email")
	private String empEmail;
}
