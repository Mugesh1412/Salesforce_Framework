package com.salesforce_TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.salesforce_pages.Contact_Creation;
import com.salesforce_pages.login_logout;

import Utility.baseClass;

public class Contact_Module extends baseClass{
	
	

	@Test
	public void New_Contact_Creation() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		Contact_Creation ConCreation = new Contact_Creation(driver);
		ConCreation.NewContact(getValues().getProperty("Firstname"), getValues().getProperty("Lastname"));
		String result = ConCreation.verifyContactName().trim();
		System.out.println(result);
		System.out.println(getValues().getProperty("Firstname"));
		String ExpectedFirstName = getValues().getProperty("Firstname").trim();
		if (result.contains(ExpectedFirstName)) {
			assertTrue(true);
			
		}
		else {
			assertTrue(false);
		}
		app.logoutIntoApp();
		
	}
	
	@Test
	public void Verify_The_Validation_Eror_On_Contact() throws InterruptedException, IOException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		Contact_Creation ConCreation = new Contact_Creation(driver);
		String result = ConCreation.validate_the_Error_On_Contact();
		System.out.println(result);
		if (result.contains("We hit a snag.")) {
			assertTrue(true);
			
		}
		else {
			assertTrue(false);
		} 
		app.logoutIntoApp();              
		
	}
}
