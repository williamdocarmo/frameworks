package com.app.ws.springbootsoapws.config;

import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.MethodEndpoint;
import org.springframework.ws.server.endpoint.interceptor.PayloadTransformingInterceptor;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import com.app.ws.springbootsoapws.utils.CommonUtils;
import com.app.ws.springbootsoapws.utils.UnauthorizedAccessException;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(CustomEndpointInterceptor.class);
	
	@Value("${security.username}")
	private String username;
	
	@Value("${security.password}")
	private String password;

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
    	MethodEndpoint methodEndpoint = (MethodEndpoint) endpoint;
    	LOG.info("Endpoint: "+methodEndpoint.getMethod());
    	
    	//HTTP Header Starts
    	TransportContext ctx = TransportContextHolder.getTransportContext();
    	HttpServletRequest httpServletRequest = null;
    	String headerusername = "";
    	String headerpassword = "";
    	
    	if( null != ctx ) {
    		httpServletRequest = ((HttpServletConnection ) ctx.getConnection()).getHttpServletRequest();
    	}
    	if(null!=httpServletRequest){
    		headerusername = httpServletRequest.getHeader("username");
    		headerpassword = httpServletRequest.getHeader("password");
    		
    		if (null == headerusername || null == headerpassword || !headerusername.equals(username) || !headerpassword.equals(password)) {
    			throw new UnauthorizedAccessException(5000, "Header User Does not have Access");
    		}
    	}
    	LOG.info("Request Coming From: " + httpServletRequest.getRemoteAddr()+":"+httpServletRequest.getRemotePort());
    	LOG.info("Username: "+headerusername+" Password: "+headerpassword);
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
        LOG.info(printData.toString());
       
        LOG.info("-------RESPONSE-------");
        printData = new StringWriter();
    	CommonUtils.getTransformer(null).transform(response, new StreamResult(printData));
    	LOG.info(printData.toString());
    }
    
    @Bean
    public PayloadValidatingInterceptor payloadValidatingInterceptor() {
		PayloadValidatingInterceptor payloadValidatingInterceptor = new PayloadValidatingInterceptor();
		ClassPathResource classpathResource = new ClassPathResource("MDCService.xsd");
		payloadValidatingInterceptor.setSchema(classpathResource);
		return payloadValidatingInterceptor;
	}
	
    @Bean
	public PayloadTransformingInterceptor payloadTransformingInterceptor() {
		ClassRelativeResourceLoader classRelativeResourceLoader = new ClassRelativeResourceLoader(this.getClass());
		PayloadTransformingInterceptor payloadTransformingInterceptor = new PayloadTransformingInterceptor();
		payloadTransformingInterceptor.setRequestXslt(classRelativeResourceLoader.getResource("request-transformation.xsl"));
		payloadTransformingInterceptor.setResponseXslt(classRelativeResourceLoader.getResource("response-transformation.xsl"));
		return payloadTransformingInterceptor;
	}
    
	@Bean
	public Wss4jSecurityInterceptor getWss4jSecurityInterceptor() {
		Wss4jSecurityInterceptor interceptor = new Wss4jSecurityInterceptor();
		interceptor.setSecurementActions(getSecurementActions());
		LOG.info("Username and Password {} {}", username, password);
		interceptor.setSecurementUsername(username);
		interceptor.setSecurementPassword(password);
		return interceptor;
	}
	
	public String getSecurementActions(){
		String securementActions = "";
		securementActions = securementActions + WSHandlerConstants.USERNAME_TOKEN;
		securementActions = securementActions + " " + WSHandlerConstants.TIMESTAMP;
		securementActions = securementActions + " " + WSHandlerConstants.SIGN_WITH_UT_KEY;
		return securementActions;
	}
    
}