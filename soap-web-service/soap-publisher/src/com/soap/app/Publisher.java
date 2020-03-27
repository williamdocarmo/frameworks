package com.soap.app;

import javax.xml.ws.Endpoint;

import com.soap.service.address.CustomAddressService;
import com.soap.service.attachment.ImageDownloadServiceProvider;
import com.soap.service.attachment.ImageServiceAcceptor;
import com.soap.service.attachment.ImageUploadServiceProvider;
import com.soap.service.mtom.ImageMTOMService;
import com.soap.service.webservice.MobileServiceImplV2;
import com.soap.service.webservice.MobileWebService;
import com.soap.service.webserviceprovider.SubscriptionServiceMessageProvider;
import com.soap.service.webserviceprovider.SubscriptionServiceSourceProvider;

public class Publisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:10001/SoapWS/Core/Mobile", new MobileWebService());
		Endpoint.publish("http://localhost:10001/SoapWS/Core/MobileV2", new MobileServiceImplV2());
		Endpoint.publish("http://localhost:10001/SoapWS/Provider/Source", new SubscriptionServiceSourceProvider());
		Endpoint.publish("http://localhost:10001/SoapWS/Provider/Message", new SubscriptionServiceMessageProvider());
		Endpoint.publish("http://localhost:10001/SoapWS/Attachment/ImageDownload", new ImageDownloadServiceProvider());
		Endpoint.publish("http://localhost:10001/SoapWS/Attachment/ImageUpload", new ImageUploadServiceProvider());
		Endpoint.publish("http://localhost:10001/SoapWS/Attachment/ImageAcceptor", new ImageServiceAcceptor());
		Endpoint.publish("http://localhost:10001/SoapWS/CustomAddress", new CustomAddressService());
		Endpoint.publish("http://localhost:10001/SoapWS/MTOMImageService", new ImageMTOMService());

	}

}
