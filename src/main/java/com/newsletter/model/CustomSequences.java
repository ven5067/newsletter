package com.newsletter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "customSequences")
public class CustomSequences {
    
	@Id
    private String id;
    private Long sequence;

}