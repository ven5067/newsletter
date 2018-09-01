package com.newsletter.service.impl;

import static com.newsletter.helper.HelperConstants.ON_ERROR;
import static com.newsletter.helper.HelperConstants.ON_SUCCESS;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.newsletter.domain.NewsLetter;
import com.newsletter.helper.NewsLetterType;
import com.newsletter.model.Mail;
import com.newsletter.service.NewsLetterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewsLetterServiceImpl implements NewsLetterService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	public void sendNewsLetter(NewsLetter newsLetter) throws MessagingException, IOException {
		try {
			emailSender.send(getMimeMessage(newsLetter));
			log.info(ON_SUCCESS);
		} catch (MailException e) {
			log.error(ON_ERROR + e);
			throw e;
		}
	}

	private MimeMessage getMimeMessage(NewsLetter newsLetter) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		Mail mail = newsLetter.getMail();

		Context context = new Context();
		context.setVariables(mail.getModel());

		setTemplate(context, newsLetter.getType(), helper);
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());

		return message;
	}

	private void setTemplate(Context context, NewsLetterType type, MimeMessageHelper helper)
			throws MessagingException {
		log.info("Setting template for type :: " + type.name());
		switch (type) {
		case BIRTHDAY:
			helper.setText(templateEngine.process("birthday-template", context), true);
			break;

		case ANNIVERSARY:
			helper.setText(templateEngine.process("anniversary-template", context), true);
			break;
		}
		log.info("Template has been set for type :: " + type.name());
	}
}