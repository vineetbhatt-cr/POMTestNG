package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		dealsPage = new DealsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickonDealsLink();
	}
	
	@Test
	public void verifyDealsLabelTest() {
		Assert.assertTrue(dealsPage.verifyDealsLabel(), "Contacts label is missing on the page");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
