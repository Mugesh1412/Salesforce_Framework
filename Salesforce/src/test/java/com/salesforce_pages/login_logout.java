package com.salesforce_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.baseClass;

public class login_logout extends baseClass {

	@FindBy(id = "username")
	public WebElement usernameBox;
	
	@FindBy(id = "password")
	public WebElement passwordBox;
	
	@FindBy(id = "Login")
	public WebElement loginButton;
	
	@FindBy(xpath = "(//span[@class='uiImage'])[1]")
	public WebElement down;
	
	@FindBy(xpath = "//a[text()='Log Out']")
	public WebElement logoutButton;
	
	@FindBy(xpath = "//lightning-icon[contains(@class,'slds-icon-standard-home setup-icon')]")
	public WebElement HomeLogo;
	
	@FindBy(id = "error")
	public WebElement errorMsg;
	
	
	public login_logout(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void loginIntoApp(String username, String password) throws InterruptedException {
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
		Thread.sleep(2000);
	}
	
	public void logoutIntoApp() {
		js.executeScript("arguments[0].click();", down);
		//down.click();
		logoutButton.click();
		
	}
	
	public boolean logo() {
		
		return HomeLogo.isDisplayed();
	}
	
	public String errMsg() {
		return errorMsg.getText();
	}
	
		
		
		
	
}
