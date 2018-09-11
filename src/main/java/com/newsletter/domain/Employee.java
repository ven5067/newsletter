package com.newsletter.domain;

import static com.newsletter.helper.EmployeeConstants.DOB_NOTNULL;
import static com.newsletter.helper.EmployeeConstants.EMPID_NOTNULL;
import static com.newsletter.helper.EmployeeConstants.FN_NOTNULL;
import static com.newsletter.helper.EmployeeConstants.ISACTIVE_NULL;
import static com.newsletter.helper.EmployeeConstants.JOINING_DATE_NOTNULL;
import static com.newsletter.helper.EmployeeConstants.LN_NOTNULL;
import static com.newsletter.helper.EmployeeConstants.MAILID_NULL;
import static com.newsletter.helper.EmployeeConstants.TIMEZONE_NOTNULL;

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
	@NotNull(message = EMPID_NOTNULL)
	private String empId;

	@Field("firstName")
	@NotNull(message = FN_NOTNULL)
	private String firstName;

	@NotNull(message = LN_NOTNULL)
	@Field("lastName")
	private String lastName;

	@Field("mail")
	@NotNull(message = MAILID_NULL)
	private String mail;

	@Field("isActive")
	@NotNull(message = ISACTIVE_NULL)
	private Boolean isActive;

	@Field("timeZone")
	@NotNull(message = TIMEZONE_NOTNULL)
	private TimeZone timeZone;

	@Field("dateOfBirth")
	@NotNull(message = DOB_NOTNULL)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;

	@Field("age")
	private Integer age;

	@Field("joiningDate")
	@NotNull(message = JOINING_DATE_NOTNULL)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate joiningDate;

}
