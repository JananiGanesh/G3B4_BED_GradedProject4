package com.gl.employeemgmtRestApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gl.employeemgmtRestApi.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().cors().disable().authorizeRequests()
				.antMatchers("/api/employee/addEmployee", "/api/employee/roles/addRoles", "/api/employee/users/adduser")
				.hasRole("ADMIN")
				.antMatchers("/api/employee/getEmployees", "/api/employee/getEmployeeById/{empId}",
						"/api/employee/deleteEmployeeById/{empId}", "/api/employee/updateEmployeeById/{empId}",
						"/api/employee/searchEmployeeByName/{empName}",
						"/api/employee/getSortedByEmployeeFirstName/{firstName}")
				.hasAnyRole("ADMIN", "USER").antMatchers("/").permitAll().and().httpBasic();
	}

}
