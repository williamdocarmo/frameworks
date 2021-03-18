package com.app.ws;

import java.util.List;

import com.app.vo.AuthenticationData;
import com.app.vo.Subscriber;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebParam.Mode;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;

@WebService(name = "SubscriberMobileService", portName = "SubscriberPort", serviceName = "SubscriberMobileService", targetNamespace = "http://service.mobile.com")
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.WRAPPED, use = Use.ENCODED)
public interface SubscriberService {
	
	@WebMethod(action = "create", exclude = false, operationName = "createMobileSubscriber")
	@WebResult(name = "affectedRows", header = false)
	public int createSubscriber(@WebParam(name = "Subscriber", header = false, mode = Mode.IN) Subscriber subscriber);
	
	@WebMethod(action = "get", exclude = false, operationName = "getMobileSubscriberByMSISDN")
	public Subscriber getSubscriber(@WebParam(name = "msisdn", header = false, mode = Mode.IN)String msisdn);
	
	@WebMethod(action = "get", exclude = false, operationName = "getMobileSubscriberByIMSI")
	public Subscriber getSubscriberImsi(@WebParam(name = "imsi", header = false, mode = Mode.IN)String imsi);
	
	@WebMethod(action = "update", exclude = false, operationName = "updateMobileSubscriber")
	@WebResult(name = "affectedRows", header = false)
	public int updateSubscriber(@WebParam(name = "MSISDN") String msisdn, @WebParam(name = "Voice2G") String voice2G, @WebParam(name = "VoLTE") String volte, @WebParam(name = "SMS") String sms, @WebParam(name = "MMS") String mms, @WebParam(name = "GPRS") String dataGprs, @WebParam(name = "LTE") String dataLte);
	
	@WebMethod(action = "delete", exclude = false, operationName = "deleteMobileSubscriber")
	@WebResult(name = "affectedRows", header = true)
	public int deleteSubscriber(@WebParam(name = "authentication", header = true, mode = Mode.IN)AuthenticationData authData, @WebParam(name = "msisdn", header = false, mode = Mode.IN)String msisdn);
	
	@WebMethod(action = "get", exclude = true, operationName = "getAllMobileSubscribers")
	public List<Subscriber> getAllSubscribers();

}