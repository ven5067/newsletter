package com.newsletter.service;

import org.springframework.stereotype.Component;

@Component
public interface SequenceGenerator {
	public Long getNextSequence(String seqName);
}
