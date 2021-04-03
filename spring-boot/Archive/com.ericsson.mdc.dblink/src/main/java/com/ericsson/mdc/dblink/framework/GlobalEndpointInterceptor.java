package com.ericsson.mdc.dblink.framework;

import java.io.StringWriter;
import java.util.Iterator;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;

import com.ericsson.mdc.dblink.utils.CommonUtils;

@Component
public class GlobalEndpointInterceptor implements EndpointInterceptor {

    private static final Log LOG = LogFactory.getLog(GlobalEndpointInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
    	WebServiceMessage webServiceMessageRequest = messageContext.getRequest();
    	SoapMessage soapMessage = (SoapMessage) webServiceMessageRequest;
    	StringWriter printData = new StringWriter();
    	
    	//Envelope Printing Starts
    	Source envelope = soapMessage.getEnvelope().getSource();
    	CommonUtils.getTransformer(null).transform(envelope, new StreamResult(printData));
    	LOG.info("-----------------------------------");
    	LOG.info("PRINTING SOAP ENVELOPE");
    	LOG.info(printData);
    	LOG.info("-----------------------------------");
    	//Envelope Printing Ends
    	
    	//SOAP Header Starts
    	SoapHeader soapHeader = soapMessage.getSoapHeader();
    	if(null!=soapHeader){
    		Iterator<SoapHeaderElement> it = soapHeader.examineAllHeaderElements();
        	LOG.info("PRINTING SOAP HEADERS ONE BY ONE");
        	while (it.hasNext()){
        		//Retrieving headers one by one
        		SoapHeaderElement headerElement = it.next();
        		LOG.info(headerElement.getName().getLocalPart()+" "+headerElement.getText());
        	}
        	printData = new StringWriter();
        	CommonUtils.getTransformer(null).transform(soapHeader.getSource(), new StreamResult(printData));
        	LOG.info("-----------------------------------");
        	LOG.info("PRINTING SOAP HEADER");
        	LOG.info(printData);
        	LOG.info("-----------------------------------");
        	//SOAP Header Ends
    	}
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        LOG.info("Handling Response in Interceptor");
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        LOG.info("Handling Exception in Interceptor");
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        LOG.info("Execute Code After Completion");
    }
}