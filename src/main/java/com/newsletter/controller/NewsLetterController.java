package com.newsletter.controller;

import static com.newsletter.helper.HelperConstants.ERROR_NEWSLETTER;
import static com.newsletter.helper.HelperConstants.SUCCESS_NEWSLETTER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsletter.domain.NewsLetter;
import com.newsletter.service.NewsLetterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/newsletter")
public class NewsLetterController {

	@Autowired
	NewsLetterService newsLetterService;

	@PostMapping("/send")
	public ResponseEntity<?> sendNewsLetter(@RequestBody NewsLetter newsLetter) {
		try {
			newsLetterService.sendNewsLetter(newsLetter);
			log.info(SUCCESS_NEWSLETTER);
			return new ResponseEntity<>(SUCCESS_NEWSLETTER, HttpStatus.OK);
		} catch (Exception e) {
			log.error(ERROR_NEWSLETTER + e);
			return new ResponseEntity<>(ERROR_NEWSLETTER, HttpStatus.OK);
		}
	}
}
