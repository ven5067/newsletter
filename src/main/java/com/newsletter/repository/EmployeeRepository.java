package com.newsletter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.newsletter.domain.Employee;

@Component
public interface EmployeeRepository extends MongoRepository<Employee, Long>, EmployeeRepositoryCustom {
	public void deleteByEmpId(String empId);
	public Employee findByEmpId(String empId);
}
