package com.newsletter.controller;

import static com.newsletter.helper.NewsLetterConstants.ON_FAILURE;
import static com.newsletter.helper.NewsLetterConstants.ON_SUCCESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsletter.domain.NewsLetter;
import com.newsletter.service.NewsLetterService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/newsletter")
public class NewsLetterController {

	@Autowired
	NewsLetterService newsLetterService;

	@PostMapping("/send")
	@ApiOperation(httpMethod = "POST", value = "Send NewsLetter", notes = "Send NewsLetter Based on the Occasion")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = ON_SUCCESS),
	        @ApiResponse(code = 500, message = ON_FAILURE)
	})
	public ResponseEntity<?> sendNewsLetter(@RequestBody NewsLetter newsLetter) {
		try {
			newsLetterService.sendNewsLetter(newsLetter);
			return new ResponseEntity<>(ON_SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ON_FAILURE, HttpStatus.OK);
		}
	}
}
