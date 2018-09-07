package com.newsletter.repository;

import org.springframework.stereotype.Component;

import com.newsletter.domain.Employee;

@Component
public interface EmployeeRepositoryCustom {
	public void updateEmployee(Employee empployee);
}