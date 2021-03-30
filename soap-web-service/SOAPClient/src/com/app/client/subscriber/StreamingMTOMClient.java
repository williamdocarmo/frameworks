package com.app.client.subscriber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.commons.io.IOUtils;

import com.app.client.SOAPClientHandler;
import com.app.client.stubs.mtom.MOTMStream;
import com.app.client.stubs.mtom.MtomStreamingService;

public class StreamingMTOMClient {

	private static String ENDPOINT = "http://localhost:9090/StreamingMTOMService";

	private MOTMStream port = null;

	public void test() {
		try {
			initializePort();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		upload();
	}

	private void initializePort() {
		MtomStreamingService service = null;
		try {
			service = new MtomStreamingService(new URL(ENDPOINT));
			service.setHandlerResolver(new HandlerResolver() {
				
				@Override
				public List<Handler> getHandlerChain(PortInfo portInfo) {
					List<Handler> handlers = new ArrayList<>();
					handlers.add(new SOAPClientHandler());
					return handlers;
				}
			});
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		MOTMStream port = service.getMTOMPort(/*new MTOMFeature()*/);
		BindingProvider bp = (BindingProvider) port;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
		this.port = port;
	}

	private void download() {
		DataHandler dataHandler = port.fileDownload("mountain.jpg");
		try {
			InputStream is = dataHandler.getInputStream();
			OutputStream os = new FileOutputStream(new File("./mountain.jpg"));
			IOUtils.copy(is, os);
			IOUtils.close(os);
			IOUtils.close(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void upload() {
		DataHandler dataHandler = new DataHandler(new FileDataSource("./mountain.jpg"));
		try {
			OutputStream os = dataHandler.getOutputStream();
			InputStream is = new FileInputStream(new File("./mountain.jpg"));
			IOUtils.copy(is, os);
			IOUtils.close(os);
			IOUtils.close(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		port.fileUpload("uploaded.jpg", dataHandler);
	}

}
