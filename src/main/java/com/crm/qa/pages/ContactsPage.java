/*
Author: Rakesh Gopari
*/
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement contactsLabel;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstNameInputField;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastNameInputField;

	@FindBy(xpath = "//div[@name='company']/input")
	WebElement companyInputField;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveButton;

	// Initializing the Page Objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void createNewContact(String firstName, String lastName, String company) {

		Actions action = new Actions(driver);
		action.moveToElement(firstNameInputField).build().perform();
		firstNameInputField.click();
		
		firstNameInputField.sendKeys(firstName);
		lastNameInputField.sendKeys(lastName);
		companyInputField.sendKeys(company);

		saveButton.click();

	}

}
