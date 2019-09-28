package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Vineet Bhatt')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects
	public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink);
//		action.moveToElement(newContact);
//		action.click().build().perform();
		action.moveToElement(contactsLink).build().perform();
		//newContact.click();	
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",newContact);
	}

	
//	Actions actions = new Actions(driver); 
//	WebElement menuHoverLink = driver.findElement(By.linkText("RENT"));
//	actions.moveToElement(menuHoverLink).perform();
//	driver.findElement(By.cssSelector("a[href='nemc.com/rentals/easy-rent']")).click();
	
	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
}

