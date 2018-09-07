package com.newsletter.domain;

import java.time.Instant;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Audit {
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private Instant createdDate;
	
	@LastModifiedBy
	private Date lastModifiedBy;
	
	@LastModifiedDate
	private Instant lastModifiedDate;

}
