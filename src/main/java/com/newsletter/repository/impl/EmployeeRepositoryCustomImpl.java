package com.newsletter.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.newsletter.domain.Employee;
import com.newsletter.repository.EmployeeRepositoryCustom;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
	
	@Autowired
    MongoOperations mongoOperations;

	@Override
	public void updateEmployee(Employee empployee) {
		mongoOperations.save(empployee);
	}
	
}
