package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	//Initializing the Page Objects
	public DealsPage() {
					PageFactory.initElements(driver, this);
				}
	
	public boolean verifyDealsLabel() {
		return dealsLabel.isDisplayed();
	}

	
}
