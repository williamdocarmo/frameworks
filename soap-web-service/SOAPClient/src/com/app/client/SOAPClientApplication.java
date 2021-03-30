package com.app.client;

import com.app.client.subscriber.StreamingMTOMClient;

public class SOAPClientApplication {
	
	public static void main(String[] args) {
		StreamingMTOMClient client = new StreamingMTOMClient();
		client.test();
	}
	
}