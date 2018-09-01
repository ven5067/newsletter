package com.newsletter.domain;

import com.newsletter.helper.NewsLetterType;
import com.newsletter.model.Mail;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewsLetter {
	
	@ApiModelProperty(notes = "Contains to, from, subject, ...etc")
	private Mail mail;
	
	@ApiModelProperty(notes = "NewsLetter Type")
	private NewsLetterType type;
}
