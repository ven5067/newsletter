package com.newsletter.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.newsletter.domain.NewsLetter;
import com.newsletter.model.Mail;
import com.newsletter.service.NewsLetterService;

@Service
public class NewsLetterServiceImpl implements NewsLetterService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
    private SpringTemplateEngine templateEngine;

	public void sendNewsLetter(NewsLetter newsLetter) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Mail mail = newsLetter.getMail();
        
        /* helper.addAttachment("logo.png", new ClassPathResource("nisum-logo.png")); */

        Context context = new Context();
        context.setVariables(mail.getModel());
        
        String html = templateEngine.process("newsletter-template", context);

        helper.setTo(mail.getTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());

        emailSender.send(message);
    }
}