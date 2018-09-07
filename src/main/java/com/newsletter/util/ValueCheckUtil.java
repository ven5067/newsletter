package com.newsletter.util;

import java.util.function.Predicate;

public class ValueCheckUtil {
	public static Predicate<Object> isNotNull = (Object obj) -> obj != null;
}
