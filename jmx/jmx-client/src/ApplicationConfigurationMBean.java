public interface ApplicationConfigurationMBean {

	public String getRemoteHost();

	public void setRemoteHost(String remoteHost);

	public String getRemotePort();

	public void setRemotePort(String remotePort);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);
	
	public String displayConfiguration(boolean display);
	
	public void resetOperation(boolean reset, String state);

}