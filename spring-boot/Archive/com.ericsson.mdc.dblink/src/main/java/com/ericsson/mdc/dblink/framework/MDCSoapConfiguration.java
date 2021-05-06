package com.ericsson.mdc.dblink.framework;

import java.util.List;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadTransformingInterceptor;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.ericsson.mdc.dblink.utils.CommonUtils;

@EnableWs
@Configuration
public class MDCSoapConfiguration extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "MDCService") //WSDL location
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("MDCPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://mdc.ericsson.com/ws/soap/");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}
	
	

	@Bean
	public XsdSchema countriesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("MDCService.xsd"));
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {

		interceptors.add(getCustomEndpointInterceptor());
		interceptors.add(getWss4jSecurityInterceptor());
	}
	
	public CustomEndpointInterceptor getCustomEndpointInterceptor() {
		CustomEndpointInterceptor interceptor = new CustomEndpointInterceptor();
		return interceptor;
	}
	
	@Bean
	public Wss4jSecurityInterceptor getWss4jSecurityInterceptor() {
		Wss4jSecurityInterceptor interceptor = new Wss4jSecurityInterceptor();
		interceptor.setSecurementActions(getSecurementActions());
		interceptor.setSecurementUsername(CommonUtils.getApplicationProperty("security.user.name"));
		interceptor.setSecurementPassword(CommonUtils.getApplicationProperty("security.user.password"));
		return interceptor;
	}
	
	public PayloadValidatingInterceptor getPayloadValidatingInterceptor() {
		PayloadValidatingInterceptor interceptor = new PayloadValidatingInterceptor();
		return interceptor;
	}
	
	public PayloadTransformingInterceptor getPayloadTransformingInterceptor() {
		return new PayloadTransformingInterceptor();
	}
	
	public String getSecurementActions(){
		String securementActions = "";
		//securementActions = securementActions + WSHandlerConstants.USERNAME_TOKEN;
		//securementActions = securementActions + " " + WSHandlerConstants.TIMESTAMP;
		//securementActions = securementActions + " " + WSHandlerConstants.SIGN_WITH_UT_KEY;
		return securementActions;
	}
}