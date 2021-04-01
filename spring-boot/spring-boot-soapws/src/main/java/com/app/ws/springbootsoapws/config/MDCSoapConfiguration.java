package com.app.ws.springbootsoapws.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadTransformingInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class MDCSoapConfiguration extends WsConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(MDCSoapConfiguration.class);
	
	@Autowired
	private CustomEndpointInterceptor customEndpointInterceptor;
	
	@Autowired
	private Wss4jSecurityInterceptor wss4jSecurityInterceptor;
	
	@Autowired
	private PayloadTransformingInterceptor payloadTransformingInterceptor;
	
	@Autowired
	private PayloadValidatingInterceptor payloadValidatingInterceptor;
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
	}

	@Bean(name = "MDCService") //WSDL location
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setSchema(xsdSchema);
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setServiceName("MDCService");
		wsdl11Definition.setPortTypeName("MDCPort");
		wsdl11Definition.setTargetNamespace("http://mdc.ericsson.com/ws/soap/");
		
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("MDCService.xsd"));
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(customEndpointInterceptor);
		interceptors.add(wss4jSecurityInterceptor);
		interceptors.add(payloadValidatingInterceptor);
		interceptors.add(payloadTransformingInterceptor);
	}
	
}