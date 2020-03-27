package com.soap.service.address;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.soap.util.ApplicationDB;
import com.soap.vo.SubscriberData;

@WebService(serviceName = "CustomAddressService", portName = "AddressServicePort", name = "AddressPortType")
@Addressing(enabled=true, required=false)
@HandlerChain(file="SOAPMessageHandlerConfiguration.xml")
public class CustomAddressService {

	/*@WebMethod(operationName = "findSubscriber")
	@WebResult(name = "GetSubscriber")
	public SubscriberData getSubscriber(@WebParam(header=true, targetNamespace="http://www.w3.org/2005/08/addressing", name="ReplyTo")AddressType ReplyTo,@WebParam(header=true, targetNamespace="http://www.w3.org/2005/08/addressing", name="FaultTo")AddressType FaultTo,@WebParam(header=true, name="MessageID", targetNamespace="http://www.w3.org/2005/08/addressing") String MessageId, @WebParam(name = "subscriberNumber") String msisdn) {
		System.out.println("Request Entered");
		if (!msisdn.contains("91"))
			throw new RuntimeException("Subscriber Number is not Valid");
		return ApplicationDB.getSubscriber(msisdn);
	}*/
	
	@WebMethod(operationName = "findSubscriber")
	@WebResult(name = "GetSubscriber")
	public SubscriberData getSubscriber(@WebParam(name = "subscriberNumber") String msisdn) {
		System.out.println("Request Entered");
		if (!msisdn.contains("91"))
			throw new RuntimeException("Subscriber Number is not Valid");
		return ApplicationDB.getSubscriber(msisdn);
	}

}
