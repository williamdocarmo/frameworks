package com.ericsson.mdc.dblink.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Validator {
	
	String[] allowedValues() default "";
	boolean validate() default false;
	boolean nullcheck() default false;
	long minVal() default Long.MIN_VALUE;
	long maxVal() default Long.MAX_VALUE;
	String regex() default "";
	int maxLength() default Integer.MAX_VALUE;
	int minLength() default Integer.MIN_VALUE;
	
}
