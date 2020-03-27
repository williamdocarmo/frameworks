package com.app.telnet;

import java.io.IOException;

public abstract class AbstractTelnetManager {
	
	public static AbstractTelnetManager getInstance() {return null;}
	
	public abstract String processInput(String in) throws IOException;
	
	public void setState(STATE state){}

}
