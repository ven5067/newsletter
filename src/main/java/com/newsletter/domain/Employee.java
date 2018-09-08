package com.newsletter.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.newsletter.model.TimeZone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "employee")
@JsonPropertyOrder({ "id", "empId", "firstName", "lastName", "mail", "dateOfBirth", "age", "isActive", "timeZone",
		"joiningDate", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate" })
public class Employee extends Audit {

	@Id
	private Long id;

	@Indexed(unique = true)
	@Field("empId")
	@NotNull(message = "EmpId is must")
	private String empId;

	@Field("firstName")
	@NotNull(message = "FirstName is must")
	private String firstName;

	@NotNull(message = "LastName is must")
	@Field("lastName")
	private String lastName;

	@Field("mail")
	@NotNull(message = "MailId is must")
	private String mail;

	@Field("isActive")
	@NotNull(message = "IsActive is must")
	private Boolean isActive;

	@Field("timeZone")
	@NotNull(message = "TimeZone is must")
	private TimeZone timeZone;

	@Field("dateOfBirth")
	@NotNull(message = "DOB is must")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;

	@Field("age")
	private Integer age;

	@Field("joiningDate")
	@NotNull(message = "JoiningDate is must")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate joiningDate;

}
