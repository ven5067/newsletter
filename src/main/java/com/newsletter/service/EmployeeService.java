package com.newsletter.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.newsletter.domain.Employee;

@Component
public interface EmployeeService {
	public void createEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(String empId);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(String empId);
}
