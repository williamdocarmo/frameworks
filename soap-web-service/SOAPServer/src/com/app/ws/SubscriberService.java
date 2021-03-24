package com.app.ws;

import java.util.List;

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
import javax.xml.ws.ServiceMode;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.AddressingFeature.Responses;

import com.app.exc.SubscriberNotFoundException;
import com.app.vo.AuthenticationData;
import com.app.vo.Subscriber;


@WebService(targetNamespace = "http://service.mobile.com")
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.WRAPPED, use = Use.LITERAL)
@HandlerChain(file = "soaphandler.xml")
@ServiceMode(javax.xml.ws.Service.Mode.MESSAGE)
public interface SubscriberService {
	
	@WebMethod(action = "create", exclude = false, operationName = "createMobileSubscriber")
	@WebResult(name = "affectedRows", header = false)
	public int createSubscriber(@WebParam(name = "SubscriberInfo", header = false, mode = Mode.IN) Subscriber subscriber);
	
	@WebMethod(action = "get", exclude = false, operationName = "getMobileSubscriberByMSISDN")
	public Subscriber getSubscriber(@WebParam(name = "msisdn", header = false, mode = Mode.IN)String msisdn);
	
	@WebMethod(action = "get", exclude = false, operationName = "getMobileSubscriberByIMSI")
	@WebResult(name = "Subscriber")
	public Subscriber getSubscriberImsi(@WebParam(name = "imsi", header = false, mode = Mode.IN)String imsi) throws SubscriberNotFoundException;
	
	@WebMethod(action = "update", exclude = true, operationName = "updateMobileSubscriber")
	@WebResult(name = "affectedRows", header = false)
	public int updateSubscriber(@WebParam(name = "MSISDN", partName = "mSiSdN") String msisdn, @WebParam(name = "Voice2G") String voice2G, @WebParam(name = "VoLTE") String volte, @WebParam(name = "SMS") String sms, @WebParam(name = "MMS") String mms, @WebParam(name = "GPRS") String dataGprs, @WebParam(name = "LTE") String dataLte);
	
	@WebMethod(action = "delete", exclude = false, operationName = "deleteMobileSubscriber")
	@WebResult(name = "affectedRows", header = true)
	@Oneway
	public int deleteSubscriber(@WebParam(name = "authentication", header = true, mode = Mode.IN)AuthenticationData authData, @WebParam(name = "msisdn", header = false, mode = Mode.IN)String msisdn);
	
	@WebMethod(action = "get", exclude = false, operationName = "getAllMobileSubscribers")
	public List<Subscriber> getAllSubscribers();
	
	@WebMethod ()
	public String performBatchOperation(@WebParam(name = "subscribers", mode = Mode.IN) List<Subscriber> subscribers, @WebParam(name = "username", header = true, mode = Mode.INOUT) Holder<String> username, @WebParam(name = "password", header = true, mode = Mode.IN) String password, @WebParam(name = "timestamp", header = true, mode = Mode.OUT) Holder<String> timestamp);

}