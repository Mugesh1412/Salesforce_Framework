package com.salesforce_TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.salesforce_pages.login_logout;

import Utility.baseClass;
import Utility.listener;



public class Login_Module extends baseClass{

	 //public static login_logout app= new login_logout(driver);;
	@Test
	public void loginWithVaildCredentials() throws InterruptedException, IOException {
		login_logout app= new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		Thread.sleep(2000);
		boolean result = app.logo();
		assertTrue(result);
		app.logoutIntoApp();
	}
	
	@Test
	public void loginWithInvaildCredentials() throws InterruptedException, IOException {
		login_logout app= new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("wrongUN"), getValues().getProperty("wrongPw"));
		String result = app.errMsg();
		if (result.contains("Please check your username and password")) {
			assertTrue(true);
			
		}
		else {
			assertTrue(false);
		}
		
	}
}
