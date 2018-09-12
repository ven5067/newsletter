package com.newsletter.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Predicate;

public class CalandarUtil {

	public static Function<LocalDate, Integer> calculateYears = (date) -> Period.between(date, LocalDate.now())
			.getYears();

	// TODO: Need to calculate for leap year
	public static Predicate<LocalDate> isEquals = (date) -> date.getDayOfYear() == LocalDate.now().getDayOfYear();

}
