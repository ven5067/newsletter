package com.newsletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class NewsletterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NewsletterApplication.class, args);
	}
	
}
