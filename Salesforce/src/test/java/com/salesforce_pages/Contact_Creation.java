package com.salesforce_pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.baseClass;

public class Contact_Creation extends baseClass{

	@FindBy(xpath = "//a[@title='Contacts']")
	public WebElement contactSection;

	@FindBy(xpath = "//div[text()='New']")
	public WebElement contactNewButton;

	@FindBy(xpath = "(//div[@role='none']//button)[1]")
	public WebElement SalutationButton;

	@FindBy(xpath = "//label[text()='First Name']/..//input")
	public WebElement FirstNameBox;

	@FindBy(xpath = "//label[text()='Last Name']/..//input")
	public WebElement LastNameBox;

	@FindBy(xpath = "//ul[@class='slds-button-group-row']//li[3]")
	public WebElement ConSaveButton;

	@FindBy(xpath = "(//span[@class='test-id__field-label'])[3]/../../..//lightning-formatted-name")
	public WebElement ActualContactName;

	@FindBy(xpath = "//h2[text()='We hit a snag.']")
	public WebElement ConError;

	public Contact_Creation(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void NewContact(String Firstname, String Lastname) {
		Account_Creation app = new Account_Creation(driver);
		app.launchServiceApp();
		js.executeScript("arguments[0].click();", contactSection);
		contactNewButton.click();
		FirstNameBox.sendKeys(Firstname);
		LastNameBox.sendKeys(Lastname);
		ConSaveButton.click();
	}

	public String verifyContactName() {
		return ActualContactName.getText();
	}

	public String validate_the_Error_On_Contact() throws IOException, InterruptedException {
		Account_Creation app = new Account_Creation(driver);
		app.launchServiceApp();
		js.executeScript("arguments[0].click();", contactSection);
		contactNewButton.click();
		ConSaveButton.click();
		Thread.sleep(3000);
		String sd = takeScreenShot("Contact_validation_Error");
		test.addScreenCaptureFromPath(sd);
		
		return ConError.getText();

	}
	
	public void RelatedContactCreation(String firstName, String lastName) {
		FirstNameBox.sendKeys(firstName);
		LastNameBox.sendKeys(lastName);
		ConSaveButton.click();
		
	}




}	

