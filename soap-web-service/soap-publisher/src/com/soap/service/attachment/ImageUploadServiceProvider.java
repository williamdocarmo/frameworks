package com.soap.service.attachment;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

@WebServiceProvider(targetNamespace="http://attachment.service.soap.com/upload")
@ServiceMode(Mode.MESSAGE)
public class ImageUploadServiceProvider implements Provider<SOAPMessage> {

	@Override
	public SOAPMessage invoke(SOAPMessage message) {
		try {
			Iterator<?> it = message.getAttachments();
			AttachmentPart attachment = null;
			if (it.hasNext()) {
				attachment = ((AttachmentPart) message.getAttachments().next());
				System.out.println("------Attachment Details------");
				System.out.println("Attachment Content ID: " + attachment.getContentId());
				System.out.println("Attachment Content Type: " + attachment.getContentType());
				System.out.println("Attachment Content Size (Bytes): " + attachment.getSize());
				System.out.println("Attachment Content Class: " + attachment.getContent().getClass());
				if (attachment.getContent() instanceof BufferedImage) {
					File outputfile = new File("incoming.jpg");
					ImageIO.write((BufferedImage) attachment.getContent(), "jpg", outputfile);
				}
			}
		} catch (Exception e) {

		}
		return message;
	}

}
