package com.jaxb.app;

import java.io.File;

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
		Object object = ObjectFactory.getObject();
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(object, System.out);
	}

	private static void unmarshall() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Object object = unmarshaller.unmarshal(new File("Request.xml"));
		System.out.println("Object: "+object);
	}
	
}
