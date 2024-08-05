package com.salesforce_TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.salesforce_pages.Account_Creation;
import com.salesforce_pages.Contact_Creation;
import com.salesforce_pages.Contact_Creation_On_Account_Section;
import com.salesforce_pages.login_logout;

import Utility.baseClass;

public class Account_Related_Contact_Creation extends baseClass {

	@Test
	public void Related_Contact() throws IOException, InterruptedException {
		login_logout app = new login_logout(driver);
		app.loginIntoApp(getValues().getProperty("UserName"), getValues().getProperty("Password"));
		Account_Creation AccCreation = new Account_Creation(driver);
		AccCreation.launchServiceApp();
		AccCreation.newAccount(getValues().getProperty("AccountName"));
		Contact_Creation_On_Account_Section relatedCon = new Contact_Creation_On_Account_Section(driver);
		relatedCon.related_Contact();
		Contact_Creation ConCreation = new Contact_Creation(driver);
		ConCreation.RelatedContactCreation(getValues().getProperty("Firstname"), getValues().getProperty("Lastname"));
		app.logoutIntoApp();
	}
}                                                    
