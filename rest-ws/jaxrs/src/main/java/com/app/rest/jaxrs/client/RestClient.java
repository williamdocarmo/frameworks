package com.app.rest.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class RestClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/messenger/webapi/messages/M3/").request().get();
		System.out.println(response.getEntity(Message.class));
		
	}

}
