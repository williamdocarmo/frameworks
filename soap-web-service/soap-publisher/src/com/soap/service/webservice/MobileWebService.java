package com.soap.service.webservice;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.soap.util.ApplicationDB;
import com.soap.util.MobileSubscriptionException;
import com.soap.util.SOAPUtils;
import com.soap.util.SecurityException;
import com.soap.util.Validator;
import com.soap.vo.SecurityDetails;
import com.soap.vo.SubscriberData;

//name => PortType in WSDL
@WebService(name = "MobileService", portName = "MobilePort", serviceName = "MobileWebService")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.ENCODED)
@HandlerChain(file = "SOAPMessageHandlerConfiguration.xml")
public class MobileWebService {

	@Resource
	WebServiceContext wsContext;

	// Hello World Web Service
	public String greet(String username) {
		System.out.println("Greet Invoked!!");
		return "Hello, " + username;
	}

	// Hello World Web Service-Customized
	@WebMethod(operationName = "greetUser")
	@WebResult(name = "greetingsMessage")
	public String greetPerson(@WebParam(name = "name") String username) {
		return "Hello, " + username;
	}

	// This Method will be excluded from WSDL
	@WebMethod(exclude = true)
	public String greetPerson2(@WebParam(name = "name") String username) {
		return "Hello, " + username;
	}

	// Client will not wait for completion- OneWay
	@WebMethod(operationName = "countAsync")
	@Oneway
	public void countBackground(@WebParam(name = "counter") int countTill) {
		for (int i = 1; i <= countTill; i++) {
			System.out.println("Counting Now: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	// Complex Data Structure
	@WebMethod(operationName = "createSubscriber")
	@WebResult(name = "createSubscriberResponse")
	public void createMobileSubcriber(@WebParam(name = "createSubscriberRequest") SubscriberData subscriber)
			throws MobileSubscriptionException {
		Validator.validateSubscriber(subscriber);
		ApplicationDB.createSubscriber(subscriber);
	}

	// SOAP Header
	@WebMethod(operationName = "createSubscriberSecure")
	@WebResult(name = "createSubscriberResponse")
	public void createMobileSubcriberSecure(@WebParam(name = "createSubscriberSecureRequest") SubscriberData subscriber,
			@WebParam(name = "Credentials", header = true) SecurityDetails secureData)
			throws MobileSubscriptionException, SecurityException {
		Validator.validateSecurity(secureData);
		Validator.validateSubscriber(subscriber);
		ApplicationDB.createSubscriber(subscriber);
	}

	// Holder Parameter and Modes
	@WebMethod(operationName = "getSecureToken")
	@WebResult(name = "calculate")
	public void calculateToken(@WebParam(name = "username", header = true, mode = Mode.INOUT) Holder<String> username,
			@WebParam(name = "password", header = true, mode = Mode.IN) String password,
			@WebParam(name = "tokenvalue", header = true, mode = Mode.OUT) Holder<String> token,
			@WebParam(name = "randomText") String freeText) {
		System.out.println(wsContext.getMessageContext().get(SOAPMessageContext.WSDL_OPERATION));
		SOAPUtils.printMessageContext(wsContext.getMessageContext());
		System.out.println("Username: " + username.value);
		System.out.println("Password: " + password);
		token.value = String.valueOf(username.hashCode()) + String.valueOf(password.hashCode());
	}

	// Throws Exception
	// TODO Need to return Error Code and Error Message
	@WebMethod(operationName = "throwError")
	public void throwException() throws MobileSubscriptionException {
		throw new MobileSubscriptionException(99, "Custom Error Message");
	}

	// Returns List of Information
	@WebMethod(operationName = "getAllSubscribers")
	@WebResult(name = "Subscriber")
	public List<SubscriberData> getAllMobileSubcribers() {
		return ApplicationDB.getSubscribers();
	}

	// Returns a single row of data
	@WebMethod(operationName = "findSubscriber")
	@WebResult(name = "createSubscriberSecureResponse")
	public SubscriberData getSubscriberByMsisdn(@WebParam(name = "subscriberNumber") String msisdn) {
		return ApplicationDB.getSubscriber(msisdn);
	}

	// Custom Namespace in Request
	@WebMethod(operationName = "deleteSubscriber", action = "delete")
	@WebResult(name = "deleteSubscriberResponse")
	public void deleteSubscriber(
			@WebParam(name = "subscriberNumber", targetNamespace = "http://custom.namespace.com") String msisdn) {
		ApplicationDB.deleteSubscriber(msisdn);
	}

	// Dummy
	public SubscriberData getDummySubscriber() {
		return ApplicationDB.getDummySubscriber();
	}

}
