package com.soap.service.attachment;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.soap.vo.SubscriberData;

@WebService(targetNamespace="http://attachment.service.soap.com/upload/service")
@HandlerChain(file = "SOAPMessageHandlerConfiguration.xml")
public class ImageServiceAcceptor {

	@Resource
	private WebServiceContext wsContext;

	@WebMethod
	public void uploadImage(SubscriberData subscriber) {
		System.out.println("Subscriber Details: \n" + subscriber);
	}

}
