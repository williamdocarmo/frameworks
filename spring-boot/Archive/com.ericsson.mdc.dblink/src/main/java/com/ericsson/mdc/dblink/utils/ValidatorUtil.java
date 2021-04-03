package com.ericsson.mdc.dblink.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
	
	public static void validateBean(Object obj) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException
	{
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldname = field.getName();
			Object fieldValue = field.get(obj);
			Validator val = field.getAnnotation(Validator.class);
			List<String> allowedValues = new ArrayList<String>();
			if (null != val && val.validate()) {
				for (String str : val.allowedValues()) {
					allowedValues.add(str);
				}
				//Null check
				String validatorError = "";
				if (val.nullcheck() && CommonUtils.isNull(fieldValue)) {
					validatorError = "Field " + fieldname + " Cannot be null.";
				}
				//if field is blank then no need to check any other validation
				if(!CommonUtils.isBlank(""+fieldValue)){
					//Allowed Values Check
					boolean isAllowedValuesAvailable = allowedValues.size()>1 ? true : !CommonUtils.isBlank(allowedValues.get(0)) ? true : false;
					if (isAllowedValuesAvailable && !allowedValues.contains(fieldValue.toString())) {
						validatorError = "Field " + fieldname + " val is " + fieldValue + " allowed value is " + allowedValues+".";
					}
					//Range Check
					if(val.maxVal() != Long.MAX_VALUE || val.minVal()!=Long.MIN_VALUE)
					{
						Integer intFieldVal = null;
						try{
							intFieldVal = Integer.parseInt(fieldValue.toString().trim());
						}catch(NumberFormatException e){
							validatorError = "Field "+fieldname +" is not in correct format, should be integer." ;
						}
						if (intFieldVal > val.maxVal() || intFieldVal < val.minVal()) {
							validatorError = "Field " + fieldname + " not in range, correct range is: [" + val.minVal() + "," + val.maxVal() + "].";
						}
					}
					//length check
					if(val.maxLength() != Integer.MAX_VALUE || val.minVal()!=Integer.MIN_VALUE)
					{
						int valueLength = (""+fieldValue).length();
						if (valueLength > val.maxLength() || valueLength < val.minLength()) {
							validatorError = "Field " + fieldname + " length is invalid, correct lenght should be within : [" + val.minLength() + "," + val.maxLength() + "].";
						}
					}
					//Regexe validation
					if(!CommonUtils.isBlank(val.regex())){
						Pattern pattern = Pattern.compile(val.regex());
						Matcher matcher = pattern.matcher(String.valueOf(fieldValue));
						if(!matcher.find()){
							validatorError = "Fieldname "+fieldname +" does not match the pre-defined pattern.";
						}
					}
				}
				if(validatorError.length()>0){
					validatorError = "Validation Error: "+validatorError;
					throw new IllegalArgumentException(validatorError);
				}
			}
		}
	}

}
