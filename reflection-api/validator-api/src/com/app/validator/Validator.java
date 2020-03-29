package com.app.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Validator {
	
	String[] allowedValues() default "";
	boolean nullcheck() default false;
	long minVal() default Long.MIN_VALUE;
	long maxVal() default Long.MAX_VALUE;
	int maxLength() default Integer.MAX_VALUE;
	int minLength() default Integer.MIN_VALUE;
	String regex() default "";
	String startsWith() default "";
}
