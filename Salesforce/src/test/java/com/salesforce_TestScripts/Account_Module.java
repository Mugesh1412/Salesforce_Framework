package com.salesforce_TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.salesforce_pages.login_logout;

import Utility.baseClass;

public class Account_Module extends baseClass {
	

	@Test
	public void New_Account_Creation() throws InterruptedException, IOException {
		
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		com.salesforce_pages.Account_Creation AccCreation = new com.salesforce_pages.Account_Creation(driver);
		AccCreation.launchServiceApp();
		AccCreation.newAccount(getValues().getProperty("AccountName"));
		String result = AccCreation.verifyAccountName().trim();
		System.out.println(result);
		System.out.println(getValues().getProperty("AccountName"));
		String AC = getValues().getProperty("AccountName").trim();
		if (result.equals(AC)) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
		app.logoutIntoApp();
	}
		
		
		@Test
		  public void Verify_The_Validation_Eror_On_Account() throws InterruptedException, IOException {
			login_logout app = new login_logout(driver);
			app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
			com.salesforce_pages.Account_Creation AccCreation = new com.salesforce_pages.Account_Creation(driver);
			AccCreation.launchServiceApp();
			String result = AccCreation.validate_the_Error_On_Account();
			if (result.contains("We hit a snag.")) {
				
				assertTrue(true);
				
			}
			else {
				assertTrue(false);
			}
			app.logoutIntoApp();
		}

	
	
	
	    
}
