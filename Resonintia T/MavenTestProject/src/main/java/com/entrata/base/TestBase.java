package com.entrata.base;

import com.entrata.ActionHelper;

public class TestBase {
	
//	@BeforeMethod
	public void setUp() throws Exception {
		ActionHelper.openBrowser("Chrome");
		ActionHelper.launchUrl("https://www.entrata.com/");
	}

//	@AfterMethod
	public void tearDown() throws Exception{
		ActionHelper.driver.close();
	}
} 
