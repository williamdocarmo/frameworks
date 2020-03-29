package com.app.main;

import org.junit.Test;

public class TestApplication extends TestFramework {
	
	@Test
	public void testExecuteCreate() throws Exception {
		executeTestcase(new Throwable().getStackTrace()[0].getMethodName());
	}
	
}
