package com.config.springbootconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db")
public class DBSettings {

	private String connection;

	private String host;

	private Integer port;

	public DBSettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBSettings(String connection, String host, Integer port) {
		super();
		this.connection = connection;
		this.host = host;
		this.port = port;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}
