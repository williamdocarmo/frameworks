package com.ericsson.mdc.dblink.framework;

import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import com.ericsson.mdc.dblink.utils.CommonUtils;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {

	private static final Log LOG = LogFactory.getLog(CustomEndpointInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
    	
    	//HTTP Header Starts
    	TransportContext ctx = TransportContextHolder.getTransportContext();
    	HttpServletRequest httpServletRequest = null;
    	String username = "";
    	String password = "";
    	
    	if( null != ctx ) {
    		httpServletRequest = ((HttpServletConnection ) ctx.getConnection()).getHttpServletRequest();
    	}
    	if(null!=httpServletRequest){
    		username = httpServletRequest.getHeader("username");
    		password = httpServletRequest.getHeader("password");
    	}
    	LOG.info("Request Coming From: " + httpServletRequest.getRemoteAddr()+":"+httpServletRequest.getRemotePort());
    	LOG.info("Username: "+username+" Password: "+password);
    	//HTTP Header Ends
    	
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        WebServiceMessage webServiceMessageRequest = messageContext.getRequest();
        WebServiceMessage webServiceMessageResponse = messageContext.getResponse();
        Source request = ((SoapMessage)webServiceMessageRequest).getEnvelope().getSource();
        Source response = ((SoapMessage)webServiceMessageResponse).getEnvelope().getSource();
        
        LOG.info("-------REQUEST-------");
        StringWriter printData = new StringWriter();
        CommonUtils.getTransformer(null).transform(request, new StreamResult(printData));
        LOG.info(printData);
       
        LOG.info("-------RESPONSE-------");
        printData = new StringWriter();
    	CommonUtils.getTransformer(null).transform(response, new StreamResult(printData));
    	LOG.info(printData);
    }
    
}