package com.ericsson.mdc.dblink.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import com.ericsson.mdc.dblink.constants.StatusCodes;
import com.ericsson.mdc.dblink.constants.StatusCodes.STATUS;
import com.ericsson.mdc.ws.soap.ResponseHeader;

public class CommonUtils {

	private static TransformerFactory transformerFactory;
	private static Properties applicationProperties;

	static {
		loadApplicationProperties();
	}

	public static Transformer getTransformer(String xslFile) throws TransformerConfigurationException {
		Transformer transformer = getTransformerFactory().newTransformer();
		if (null != xslFile) {
			transformer = getTransformerFactory().newTransformer(new StreamSource(xslFile));
		}
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
		return transformer;
	}

	private static TransformerFactory getTransformerFactory() {
		if (null == transformerFactory) {
			transformerFactory = TransformerFactory.newInstance();
		}
		return transformerFactory;
	}

	private static void loadApplicationProperties() {
		try {
			applicationProperties = new Properties();
			applicationProperties.load(new FileInputStream("application.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getApplicationProperty(String property) {
		return applicationProperties.getProperty(property);
	}

	public static boolean isNull(Object obj) {
		boolean isnull = false;
		if (obj == null) {
			isnull = true;
		} else if (obj instanceof String){
			isnull = isBlank(String.valueOf(obj));
		}
		return isnull;
	}

	public static boolean isBlank(final CharSequence charSeq) {
		int strLen;
		if (charSeq == null || "null".equals(charSeq) || (strLen = charSeq.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(charSeq.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public static XMLGregorianCalendar getXmlGregorianCalendar(String date) {
		if (CommonUtils.isNull(date)) {
			return null;
		}
		Date timestamp_date = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			timestamp_date = df.parse(date);
		} catch (ParseException e) {
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(timestamp_date);
		XMLGregorianCalendar xmlgc = null;
		try {
			xmlgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			return null;
		}
		return xmlgc;
	}
	
	public static XMLGregorianCalendar getXmlGregorianCalendar(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		XMLGregorianCalendar xmlgc = null;
		try {
			xmlgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			return null;
		}
		return xmlgc;
	}
	
	public static Date getDate(XMLGregorianCalendar xgc) {
		return xgc.toGregorianCalendar().getTime();
	}

	public static ResponseHeader generateResponseHeader(STATUS status) {
		ResponseHeader header = new ResponseHeader();
		if (status.equals(STATUS.EMPTY_RESOURCE_LIST)) {
			header = getHeader(StatusCodes.EMPTY_RESOURCE_LIST, StatusCodes.MESSAGE_EMPTY_RESOURCE_LIST, StatusCodes.SOURCE_DBLINK);
		}
		if (status.equals(STATUS.INPUT_ERROR)) {
			header = getHeader(StatusCodes.ERROR_INPUT_DATA, StatusCodes.MESSAGE_ERROR_INPUT_DATA, StatusCodes.SOURCE_DBLINK);
		}
		if (status.equals(STATUS.MANDATORY_PARAM_MISSING)) {
			header = getHeader(StatusCodes.MANDATORY_PARAM_MISSING, StatusCodes.MESSAGE_MANDATORY_PARAM_MISSING, StatusCodes.SOURCE_DBLINK);
		}
		if (status.equals(STATUS.SUCCESSFUL)) {
			header = getHeader(StatusCodes.OPERATION_SUCCESS, StatusCodes.MESSAGE_SUCCESSFUL, StatusCodes.SOURCE_MDCDB);
		}
		if (status.equals(STATUS.UNAUTHORIZED)) {
			header = getHeader(StatusCodes.OPERATION_UNAUTHORIZED, StatusCodes.MESSAGE_UNAUTHORIZED, StatusCodes.SOURCE_MDCDB);
		}
		if (status.equals(STATUS.UNHANDLED_EXCEPTION)) {

		}
		if (status.equals(STATUS.USER_NOT_EXIST)) {
			header = getHeader(StatusCodes.USER_NOT_EXISTS, StatusCodes.MESSAGE_USER_NOT_EXISTS, StatusCodes.SOURCE_MDCDB);
		}
		if (status.equals(STATUS.USER_ALREADY_EXIST)) {
			header = getHeader(StatusCodes.USER_ALREADY_EXISTS, StatusCodes.MESSAGE_USER_ALREADY_EXISTS, StatusCodes.SOURCE_MDCDB);
		}
		if (status.equals(STATUS.EMPTY_ACTIVITY_LIST)) {
			header = getHeader(StatusCodes.EMPTY_ACTIVITY_LIST, StatusCodes.MESSAGE_EMPTY_ACTIVITY_LIST, StatusCodes.SOURCE_MDCDB);
		}
		header.setTimestamp(String.valueOf(new Date()));
		return header;
	}
	
	private static ResponseHeader getHeader(String statusCode, String statusMessage, String source){
		ResponseHeader header = new ResponseHeader();
		header.setSource(source);
		header.setStatusCode(statusCode);
		header.setStatusMessage(statusMessage);
		return header;
	}
	
}
