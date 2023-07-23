package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@href='/contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//a[@href='/deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[@href='/tasks']")
	WebElement tasksLink;

	@FindBy(xpath = "(//button[@class='ui mini basic icon button'])[2]")
	WebElement newContactButton;

	// Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public TasksPage clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactButton.click();
		return new TasksPage();
	}

}
