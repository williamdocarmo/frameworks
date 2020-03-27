package com.soap.client.addressing;

import java.util.Map;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.AddressingFeature;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

import com.soap.client.addressing.clientgen.AddressPortType;
import com.soap.client.addressing.clientgen.CustomAddressService;
import com.soap.client.addressing.clientgen.SubscriberData;
import com.sun.xml.internal.ws.api.addressing.AddressingVersion;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import com.sun.xml.internal.ws.developer.WSBindingProvider;
import com.sun.xml.internal.ws.message.StringHeader;
import com.sun.xml.ws.transport.async_client_transport.AsyncClientTransportFeature;
import com.sun.xml.ws.transport.async_client_transport.NonAnonymousResponsesReceiver;

public class WSAdressClient {

	private static final String ENDPOINT = "http://localhost:10002/SoapWS/CustomAddress";
	private static final AddressingVersion WS_ADDR_VER = AddressingVersion.W3C;

	static AddressPortType port;

	static {
		CustomAddressService service = new CustomAddressService();
		AddressingFeature addressingFeature = new AddressingFeature(true, false);
		port = service.getAddressServicePort(addressingFeature);
		WSBindingProvider bindingProvider = ((WSBindingProvider) port);
		Map<String, Object> requestContext = bindingProvider.getRequestContext();
		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT);
		requestContext.put(BindingProvider.USERNAME_PROPERTY, "myusername");
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, "mypassword");
		/*StringHeader messageId = new StringHeader(WS_ADDR_VER.messageIDTag, "1234");
		StringHeader replyTo = new StringHeader(WS_ADDR_VER.replyToTag, "http://172.18.208.1:8888/replyto");
		StringHeader faultTo = new StringHeader(WS_ADDR_VER.faultToTag, "http://172.18.208.1:8889/faultto");
		bindingProvider.setOutboundHeaders(messageId, replyTo, faultTo);*/
	}

	public static void main(String[] args) {
		SubscriberData subscriber = port.findSubscriber("919903123499");
		System.out.println(subscriber.getOffer());
	}

}