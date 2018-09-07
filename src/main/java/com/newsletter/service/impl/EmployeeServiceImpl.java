package com.newsletter.service.impl;

import static com.newsletter.util.CalandarUtil.calculateAge;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.newsletter.domain.Employee;
import com.newsletter.repository.EmployeeRepository;
import com.newsletter.service.EmployeeService;
import com.newsletter.service.SequenceGenerator;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	@Qualifier("sequenceGeneratorImpl")
	private SequenceGenerator sequenceGenerator;
	
	@Override
	public void createEmployee(Employee employee) {
		employee.setId(sequenceGenerator.getNextSequence("customSequences"));
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(String empId) {
		employeeRepository.deleteByEmpId(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String empId) {
		Employee employee = employeeRepository.findByEmpId(empId);
		transformEmployee(employee);
		return employee;
	}
	
	private void transformEmployee(Employee employee) {
		employee.setAge(calculateAge(employee.getDateOfBirth(), LocalDate.now()));
	}
	
}
