package com.newsletter.domain;

import com.newsletter.helper.NewsLetterType;
import com.newsletter.model.Mail;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewsLetter {
	private Mail mail;
	private NewsLetterType type;
}
