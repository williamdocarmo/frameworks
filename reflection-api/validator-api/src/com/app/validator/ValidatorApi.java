package com.app.validator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorApi {
	
	public static String validate(Object obj) throws IllegalArgumentException, IllegalAccessException {
		String validatorError = "";
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldname = field.getName();
			Object fieldValue = field.get(obj);
			Validator val = field.getAnnotation(Validator.class);
			List<String> allowedValues = new ArrayList<String>();
			if (null != val) {
				for (String str : val.allowedValues()) {
					allowedValues.add(str);
				}
				// Null check
				if (isNull("" + fieldValue)) {
					if (val.nullcheck()) {
						validatorError += "Field " + fieldname + " Cannot be null.";
					}
				} else {
					// Allowed Values Check
					boolean isAllowedValuesAvailable = allowedValues.size() > 1 ? true
							: !isNull(allowedValues.get(0)) ? true : false;
					if (isAllowedValuesAvailable && !allowedValues.contains(fieldValue.toString())) {
						validatorError += "Field " + fieldname + " val is " + fieldValue + " allowed value is " + allowedValues + ".";
					}
					// Range Check
					if (val.maxVal() != Long.MAX_VALUE || val.minVal() != Long.MIN_VALUE) {
						Integer intFieldVal = null;
						try {
							intFieldVal = Integer.parseInt(fieldValue.toString().trim());
						} catch (NumberFormatException e) {
							validatorError += "Field " + fieldname + " is not in correct format, should be integer.";
						}
						if (intFieldVal > val.maxVal() || intFieldVal < val.minVal()) {
							validatorError += "Field " + fieldname + " not in range, correct range is: [" + val.minVal() + "," + val.maxVal() + "].";
						}
					}
					// length check
					if (val.maxLength() != Integer.MAX_VALUE || val.minVal() != Integer.MIN_VALUE) {
						int valueLength = ("" + fieldValue).length();
						if (valueLength > val.maxLength() || valueLength < val.minLength()) {
							validatorError += "Field " + fieldname + " length is invalid, correct length should be within : [" + val.minLength() + "," + val.maxLength() + "].";
						}
					}
					// Regex validation
					if (!isNull(val.regex())) {
						Pattern pattern = Pattern.compile(val.regex());
						Matcher matcher = pattern.matcher(String.valueOf(fieldValue));
						if (!matcher.find()) {
							validatorError += "Field " + fieldname + " does not match the pre-defined pattern.";
						}
					}
					//Startswith Check
					if(!isNull(val.startsWith()) && !String.valueOf(fieldValue).startsWith(val.startsWith())){
						validatorError += "Field " + fieldname + " should start with "+val.startsWith()+ ".";
					}
					
				}
				
			}
		}
		if (validatorError.length() > 0) {
			validatorError = " Bean name: " + obj.getClass().getSimpleName()+": "+validatorError;
		}
		return validatorError;
	}
	
	public static boolean isNull(final CharSequence charSeq) {
		int strLen;
		if (charSeq == null || charSeq.equals("null") || (strLen = charSeq.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(charSeq.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

}
