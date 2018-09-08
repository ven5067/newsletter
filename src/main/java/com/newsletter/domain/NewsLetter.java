package com.newsletter.domain;

import com.newsletter.model.Mail;
import com.newsletter.model.NewsLetterType;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class NewsLetter {
	
	@ApiModelProperty(notes = "Contains to, from, subject, ...etc")
	private Mail mail;
	
	@ApiModelProperty(notes = "NewsLetter Type")
	private NewsLetterType type;
}
