package com.newsletter.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TimeZone {
	INDIA("Asia/Kolkata");

	private String value;
}
