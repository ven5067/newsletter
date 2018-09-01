package com.newsletter.controller;

import static com.newsletter.helper.HelperConstants.ERROR_NEWSLETTER;
import static com.newsletter.helper.HelperConstants.SUCCESS_NEWSLETTER;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsletter.domain.NewsLetter;
import com.newsletter.model.Mail;
import com.newsletter.service.NewsLetterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/newsletter")
public class NewsLetterController {
	
	@Autowired
	NewsLetterService newsLetterService;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendNewsLetter(@RequestBody NewsLetter newsLetter){
		
		Mail mail = new Mail();
        mail.setFrom("ven5067@gmail.com");
        mail.setTo("vmeesala@nisum.com");
        mail.setSubject("Wishing you a very happy birthday!");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Venugopal");
        model.put("location", "Hyderabad");
        model.put("organization", "Nisum");
        model.put("signature", "https://ven.com");
        model.put("message", "Yes, it’s a special day, because the kindest and beautiful hearted person was born on this special day. Wishing you a very happy birthday!");
        mail.setModel(model);
		
		try {
			newsLetterService.sendNewsLetter(newsLetter);
			log.info(SUCCESS_NEWSLETTER);
			return new ResponseEntity<>("Newsletter has been sent successfully", HttpStatus.OK);
		} catch (Exception e) {
			log.error(ERROR_NEWSLETTER + e);
			return new ResponseEntity<>(ERROR_NEWSLETTER, HttpStatus.OK);
		}
	}
}
