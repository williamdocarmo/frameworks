package com.app.util;

import javax.persistence.AttributeConverter;

public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean b) {
		return (null != b && b ? "Y" : "N");
	}

	@Override
	public Boolean convertToEntityAttribute(String s) {
		return (s.equals("Y"));
	}

}
