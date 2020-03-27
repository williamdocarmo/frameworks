package com.soap.service.sei;

import java.util.List;

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

import com.soap.util.MobileSubscriptionException;
import com.soap.util.SecurityException;
import com.soap.vo.SecurityDetails;
import com.soap.vo.SubscriberData;

@WebService(name = "MobileService", portName = "MobilePort", serviceName = "MobileWebService")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.ENCODED)

public interface MobileService {

	String greet(String username);

	@WebMethod(operationName = "greetUser")
	@WebResult(name = "greetingsMessage")
	String greetPerson(@WebParam(name = "name") String username);

	@WebMethod(exclude = true)
	String greetPerson2(@WebParam(name = "name") String username);

	@WebMethod(operationName = "countAsync")
	@Oneway
	void countBackground(@WebParam(name = "counter") int countTill);

	@WebMethod(operationName = "createSubscriber")
	@WebResult(name = "createSubscriberResponse")
	void createMobileSubcriber(@WebParam(name = "createSubscriberRequest") SubscriberData subscriber)
			throws MobileSubscriptionException;

	@WebMethod(operationName = "createSubscriberSecure")
	@WebResult(name = "createSubscriberResponse")
	void createMobileSubcriberSecure(@WebParam(name = "createSubscriberSecureRequest") SubscriberData subscriber,
			@WebParam(name = "Credentials", header = true) SecurityDetails secureData)
			throws MobileSubscriptionException, SecurityException;

	@WebMethod(operationName = "getSecureToken")
	@WebResult(name = "calculate")
	void calculateToken(@WebParam(name = "username", header = true, mode = Mode.INOUT) Holder<String> username,
			@WebParam(name = "password", header = true, mode = Mode.IN) String password,
			@WebParam(name = "tokenvalue", header = true, mode = Mode.OUT) Holder<String> token,
			@WebParam(name = "randomText") String freeText);

	@WebMethod(operationName = "throw")
	void throwException() throws MobileSubscriptionException;

	@WebMethod(operationName = "getAllSubscribers")
	@WebResult(name = "Subscriber")
	List<SubscriberData> getAllMobileSubcribers();

	@WebMethod(operationName = "findSubscriber")
	@WebResult(name = "createSubscriberSecureResponse")
	SubscriberData getSubscriberByMsisdn(@WebParam(name = "subscriberNumber") String msisdn);

	@WebMethod(operationName = "deleteSubscriber", action = "delete")
	@WebResult(name = "deleteSubscriberResponse")
	void deleteSubscriber(
			@WebParam(name = "subscriberNumber", targetNamespace = "http://custom.namespace.com") String msisdn);

	SubscriberData getDummySubscriber();

}