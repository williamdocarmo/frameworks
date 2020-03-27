package com.java.serialization.topic1;

import java.io.Serializable;
import java.util.Arrays;

public class Model implements Serializable {

	private static final long serialVersionUID = 2655713858982602341L;

	private String param1;
	private int param2;
	private int[] param3;
	transient private String password;

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public int getParam2() {
		return param2;
	}

	public void setParam2(int param2) {
		this.param2 = param2;
	}

	public int[] getParam3() {
		return param3;
	}

	public void setParam3(int[] param3) {
		this.param3 = param3;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Model [param1=" + param1 + ", param2=" + param2 + ", param3=" + Arrays.toString(param3) + ", password="
				+ password + "]";
	}

	public Model(String param1, int param2, int[] param3, String password) {
		super();
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.password = password;
	}

}
