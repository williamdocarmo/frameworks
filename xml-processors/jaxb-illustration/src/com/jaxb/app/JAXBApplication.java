package com.jaxb.app;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.jaxb.app.vo.Employee;

public class JAXBApplication {
	
	public static void main(String args[]) throws JAXBException {
		marshall();
		
		unmarshall();
		
	}
	
	private static void marshall() throws JAXBException {
		Object object = ObjectMaker.makeObject();
		StringWriter writer = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(object, writer);
		System.out.println(writer.toString());
	}

	private static void unmarshall() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Object object = unmarshaller.unmarshal(new File("Request.xml"));
		System.out.println("Object: "+object);
	}
	
}
