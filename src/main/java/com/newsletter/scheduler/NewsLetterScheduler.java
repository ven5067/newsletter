package com.newsletter.scheduler;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NewsLetterScheduler {

//	@Scheduled(cron = "0 0 0 * * ?")
	@Scheduled(cron = "0 0 0 * * ?")
	public void create() {
		final LocalDateTime start = LocalDateTime.now();
		log.info("::::::::::::::::::::::::" + start.toString());
	}
	
}
