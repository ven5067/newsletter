package com.newsletter.util;

import java.time.LocalDate;
import java.time.Period;

public class CalandarUtil {

	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		return Period.between(birthDate, currentDate).getYears();
	}
	
}
