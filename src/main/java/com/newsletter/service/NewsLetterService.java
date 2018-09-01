package com.newsletter.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;

import com.newsletter.domain.NewsLetter;

@Component
public interface NewsLetterService {
	public void sendNewsLetter(NewsLetter newsLetter) throws MessagingException, IOException;
}