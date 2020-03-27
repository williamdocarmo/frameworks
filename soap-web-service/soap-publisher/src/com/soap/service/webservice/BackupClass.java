package com.soap.service.webservice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


//MTOM
//SOAPBinding
//SEI
//BindingType
public class BackupClass {

	public byte[] downloadFile(String fileName) throws IOException {
		File file = new File("C:\\Users\\heisenberg\\Desktop\\" + fileName);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream inputStream = new BufferedInputStream(fis);
		byte[] fileBytes = new byte[(int) file.length()];
		inputStream.read(fileBytes);
		inputStream.close();
		return fileBytes;
	}

}
