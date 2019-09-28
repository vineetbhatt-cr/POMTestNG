package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName ="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
	    loginPage = new LoginPage();
	    contactsPage = new ContactsPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    testUtil.switchToFrame();
	    contactsPage = homePage.clickonContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactLabel(), "Contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactsPage.selectContacts("Pankaj Kumar");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	//Data will be fetched from excel sheet
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "YK", "YB", "HarterLadley");
		contactsPage.createNewContact(title,firstName,lastName,company);	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
