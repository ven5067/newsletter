package com.newsletter.domain;

import com.newsletter.model.Mail;
import com.newsletter.model.NewsLetterType;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsLetter {
	
	@ApiModelProperty(notes = "Contains to, from, subject, ...etc")
	private Mail mail;
	
	@ApiModelProperty(notes = "NewsLetter Type")
	private NewsLetterType type;
}
