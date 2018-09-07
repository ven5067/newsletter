package com.newsletter.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "employee")
@JsonPropertyOrder({ "id", "empId", "firstName", "lastName", "dateOfBirth", "joiningDate", "createdBy", "createdDate",
		"lastModifiedBy", "lastModifiedDate" })
public class Employee extends Audit {

	@Id
	@JsonIgnore
	private long id;

	@Indexed(unique = true)
	@Field("empId")
	private String empId;

	@Field("firstName")
	private String firstName;

	@Field("lastName")
	private String lastName;

	@Field("dateOfBirth")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;

	@Field("joiningDate")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate joiningDate;

}
