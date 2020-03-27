package com.soap.service.mtom;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

@MTOM
@WebService(name="MOTMImageService", portName="MTOMService", serviceName="MTOMImageService")
@BindingType(SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class ImageMTOMService {

	public Image retrieveImage(String name) {
		try {
			File image = new File(name);
			return ImageIO.read(image);
		} catch (IOException e) {
			return null;
		}
	}

}