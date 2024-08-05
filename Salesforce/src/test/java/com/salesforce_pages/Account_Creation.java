package com.salesforce_pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.baseClass;

public class Account_Creation extends baseClass {

	@FindBy(xpath = "//button[@title='App Launcher']")
	public WebElement AppLauncher;
	
	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	public WebElement searchApp;
	
	@FindBy(xpath = "//p[text()='Service']")
	public WebElement serviceApp;
	
	@FindBy(xpath = "//a[@title='Accounts']")
	public WebElement AccountsSection;
	
	@FindBy(xpath = "//div[text()='New']")
	public WebElement AccountNewButton;
	
	@FindBy(xpath = "(//label[contains(.,'*Account Name')]/following::input)[1]")
	public WebElement AccountNameBox;
	
	@FindBy(xpath = "//ul[@class='slds-button-group-row']//li[3]")
	public WebElement AccSaveButton;
	
	@FindBy(xpath = "//h2[text()='We hit a snag.']")
	public WebElement AccError;
	
	@FindBy(xpath = "(//span[@class='test-id__field-label'])[3]/../../..//lightning-formatted-text")
	public WebElement ActualAccountName;
	
	public Account_Creation(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	public void launchServiceApp() {
		AppLauncher.click();
		//searchApp.click();
		serviceApp.click();
	}
	
	public void newAccount(String Accountname) throws InterruptedException {
		//AccountsSection.click();
		js.executeScript("arguments[0].click();", AccountsSection);
		//Thread.sleep(2000);
		//driver.navigate().refresh();
		AccountNewButton.click();
		AccountNameBox.sendKeys(Accountname);
		AccSaveButton.click();
	}
	
	
	public String verifyAccountName() {
		
		return ActualAccountName.getText();
	}
	
	public String validate_the_Error_On_Account() throws IOException, InterruptedException {
		js.executeScript("arguments[0].click();", AccountsSection);
		AccountNewButton.click();
		AccSaveButton.click();
		Thread.sleep(3000);
		String sd = takeScreenShot("Account_validation_Error");
		test.addScreenCaptureFromPath(sd);
		
		return AccError.getText();
	}
	
}
