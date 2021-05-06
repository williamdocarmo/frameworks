package com.app.vo;

public class ServiceData {
	
	private boolean service_2g;
	
	private boolean service_4g;
	
	private boolean service_volte;
	
	private boolean service_mms;

	public boolean isService_2g() {
		return service_2g;
	}

	public void setService_2g(boolean service_2g) {
		this.service_2g = service_2g;
	}

	public boolean isService_4g() {
		return service_4g;
	}

	public void setService_4g(boolean service_4g) {
		this.service_4g = service_4g;
	}

	public boolean isService_volte() {
		return service_volte;
	}

	public void setService_volte(boolean service_volte) {
		this.service_volte = service_volte;
	}

	public boolean isService_mms() {
		return service_mms;
	}

	public void setService_mms(boolean service_mms) {
		this.service_mms = service_mms;
	}

	@Override
	public String toString() {
		return "ServiceData [service_2g=" + service_2g + ", service_4g=" + service_4g + ", service_volte="
				+ service_volte + ", service_mms=" + service_mms + "]";
	}

	public ServiceData() {
		super();
	}

	public ServiceData(boolean service_2g, boolean service_4g, boolean service_volte, boolean service_mms) {
		super();
		this.service_2g = service_2g;
		this.service_4g = service_4g;
		this.service_volte = service_volte;
		this.service_mms = service_mms;
	}
	
}
