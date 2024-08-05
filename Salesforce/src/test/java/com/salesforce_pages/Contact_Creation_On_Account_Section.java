package com.salesforce_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.baseClass;

public class Contact_Creation_On_Account_Section extends baseClass{

	@FindBy(xpath = "(//span[text()='Contacts'])[2]")
	public WebElement relatedContact;

	@FindBy(xpath = "(//button[@name='NewContact'])[1]")
	public WebElement RelatedConNewButton;

	public Contact_Creation_On_Account_Section(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void related_Contact() throws InterruptedException {

		Thread.sleep(10000);
		js.executeScript("window.scrollTo(0,800)");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", RelatedConNewButton);
	}
}
