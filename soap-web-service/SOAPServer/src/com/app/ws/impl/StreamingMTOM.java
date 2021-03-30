package com.app.ws.impl;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

import com.sun.xml.ws.developer.StreamingAttachment;
import com.sun.xml.ws.developer.StreamingDataHandler;

@MTOM
@WebService(name = "MOTMStream", portName = "MTOMPort", serviceName = "MtomStreamingService", targetNamespace = "http://example.org")
@BindingType(SOAPBinding.SOAP11HTTP_MTOM_BINDING)
@StreamingAttachment(parseEagerly = true, memoryThreshold = 40000L)
@HandlerChain(file = "soaphandler.xml")
public class StreamingMTOM {

	@WebMethod
	public void fileUpload(String fileName, @XmlMimeType("application/octet-stream") DataHandler data) {
		try {
			StreamingDataHandler dh = (StreamingDataHandler) data;
			File file = new File(fileName);
			dh.moveTo(file);
			dh.close();
		} catch (Exception e) {
			throw new WebServiceException(e);
		}
	}

	@XmlMimeType("application/octet-stream")
	@WebMethod
	public DataHandler fileDownload(String filename) {
		return new DataHandler(new FileDataSource(filename));
	}
}