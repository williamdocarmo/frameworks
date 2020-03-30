package com.app.main;

import org.junit.Test;

public class TestApplication extends TestFramework {
	
	@Test
	public void testExecuteCreate() throws Exception {
		String expected = "CREATE:SUCCESSFUL";
		executeTestcase(new Throwable().getStackTrace()[0].getMethodName(), expected);
	}
	
	@Test
	public void testExecuteDelete() throws Exception {
		String expected = "DELETE:SUCCESSFUL";
		executeTestcase(new Throwable().getStackTrace()[0].getMethodName(), expected);
	}
	
	@Test
	public void testExecuteGet() throws Exception {
		String expected = "GET:SUCCESSFUL";
		executeTestcase(new Throwable().getStackTrace()[0].getMethodName(), expected);
	}
	
}
