package com.newsletter.helper;

import java.util.HashMap;
import java.util.Map;

import com.newsletter.domain.Employee;
import com.newsletter.domain.NewsLetter;
import com.newsletter.model.Mail;
import com.newsletter.model.NewsLetterType;
import com.newsletter.util.CalandarUtil;

public class NewsLetterHelper {

	private static final String NAME = "name";
	private static final String ORG = "organization";
	private static final String MESSAGE = "message";
	private static final String YEARS = "years";

	private static final String FROM = "ven5067@gmail.com";
	private static final String ORGANIZATION = "Nisum Technologies";
	private static final String BIRTHDAY_SUB = "Wishing you a very happy work birthday!";
	private static final String BIRTHDAY_MSG = "Yes, it’s a special day, because the kindest and beautiful hearted person was born on this special day. Happy birthday, thanks for joining us.";
	private static final String ANNIVERSARY_SUB = "Wishing you a very happy work anniversary!";
	private static final String ANNIVERSARY_MSG = "Thank you for choosing us among a wide range of companies. We appriciate your trust and support. Your honest feedbacks help us improve and get better for you. Without you we would not be there where we are now. We wish you success.";

	public static NewsLetter prepareNewsLetter(Employee employee, NewsLetterType type) {
		if (type.equals(NewsLetterType.ANNIVERSARY)) {
			Mail mail = Mail.builder().from(FROM).to(employee.getMail()).subject(ANNIVERSARY_SUB)
					.model(buildAnniversaryModel(employee)).build();
			return NewsLetter.builder().mail(mail).type(NewsLetterType.ANNIVERSARY).build();
		} else {
			Mail mail = Mail.builder().from(FROM).to(employee.getMail()).subject(BIRTHDAY_SUB)
					.model(buildBirthDayModel(employee)).build();
			return NewsLetter.builder().mail(mail).type(NewsLetterType.BIRTHDAY).build();
		}
	}

	public static Map<String, Object> buildAnniversaryModel(Employee employee) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(NAME, employee.getFirstName());
		model.put(ORG, ORGANIZATION);
		model.put(MESSAGE, ANNIVERSARY_MSG);
		model.put(YEARS, CalandarUtil.calculateYears.apply(employee.getJoiningDate()));
		return model;
	}

	public static Map<String, Object> buildBirthDayModel(Employee employee) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(NAME, employee.getFirstName());
		model.put(ORG, ORGANIZATION);
		model.put(MESSAGE, BIRTHDAY_MSG);
		return model;
	}
}
