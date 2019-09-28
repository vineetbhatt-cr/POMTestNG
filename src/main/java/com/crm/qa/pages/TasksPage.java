package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class TasksPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLabel;
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTasksLabel() {
		return tasksLabel.isDisplayed();
	}
	
	

}
