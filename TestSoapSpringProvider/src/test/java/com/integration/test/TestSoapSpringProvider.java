package com.integration.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@ComponentScan(basePackages = {"localhost._8080.studentdetails.ws"})
@SpringBootConfiguration
@SpringBootApplication
public class TestSoapSpringProvider extends WsConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(TestSoapSpringProvider.class, args);
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
		MessageDispatcherServlet  serv = new MessageDispatcherServlet();
		serv.setApplicationContext(applicationContext);
		serv.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(serv,"/ws/*");
		
	}
	
	@Bean
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setLocationUri("/ws");
		defaultWsdl11Definition.setPortTypeName("Test");
		defaultWsdl11Definition.setTargetNamespace("http://localhost:8080/studentdetails/ws");
		defaultWsdl11Definition.setSchema(xsdSchema);
		
		return defaultWsdl11Definition;
		
	}
	
	@Bean
	public XsdSchema studentSchema() {
		return new SimpleXsdSchema(new ClassPathResource("studentdetails.xsd"));
	}
}
