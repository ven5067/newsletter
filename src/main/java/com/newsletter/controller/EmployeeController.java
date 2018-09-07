package com.newsletter.controller;

import static com.newsletter.helper.EmployeeConstants.EMP_CREATED;
import static com.newsletter.helper.EmployeeConstants.EMP_CREATE_ERROR;
import static com.newsletter.helper.EmployeeConstants.EMP_DELETED;
import static com.newsletter.helper.EmployeeConstants.EMP_DELETE_ERROR;
import static com.newsletter.helper.EmployeeConstants.EMP_FETCH_EMPS_ERROR;
import static com.newsletter.helper.EmployeeConstants.EMP_FETCH_EMP_ERROR;
import static com.newsletter.helper.EmployeeConstants.EMP_NOT_FOUND;
import static com.newsletter.helper.EmployeeConstants.EMP_UPDATED;
import static com.newsletter.helper.EmployeeConstants.EMP_UPDATE_ERROR;
import static com.newsletter.util.ValueCheckUtil.isNotNull;

import javax.validation.Valid;

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

import com.newsletter.domain.Employee;
import com.newsletter.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee employee) {
		try {
			employeeService.createEmployee(employee);
			return new ResponseEntity<>(EMP_CREATED, HttpStatus.OK);
		} catch (Exception e) {
			log.error(EMP_CREATE_ERROR + e);
			return new ResponseEntity<>(EMP_CREATE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody @Valid Employee employee) {
		try {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<>(EMP_UPDATED, HttpStatus.OK);
		} catch (Exception e) {
			log.error(EMP_UPDATE_ERROR + e);
			return new ResponseEntity<>(EMP_UPDATE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String empId) {
		try {
			employeeService.deleteEmployee(empId);
			return new ResponseEntity<>(EMP_DELETED, HttpStatus.OK);
		} catch (Exception e) {
			log.error(EMP_DELETE_ERROR + e);
			return new ResponseEntity<>(EMP_DELETE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees(){
		try {
			return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(EMP_FETCH_EMPS_ERROR + e);
			return new ResponseEntity<>(EMP_FETCH_EMPS_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable String empId){
		try {
			if(isNotNull.test(employeeService.getEmployeeById(empId))) {
				return new ResponseEntity<>(employeeService.getEmployeeById(empId), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(EMP_NOT_FOUND, HttpStatus.NOT_FOUND);
			} 
		} catch (Exception e) {
			log.error(EMP_FETCH_EMP_ERROR + e);
			return new ResponseEntity<>(EMP_FETCH_EMP_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
