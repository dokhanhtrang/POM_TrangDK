package com.bankguru.customer;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.HomePagePO;
import pages.LoginPagePO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewCustomer extends AbstractTest {
	WebDriver driver;
	String email, userName, password;
	private LoginPagePO loginPage;
	private HomePagePO homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void stepForAll(String browser, String url) {
		driver = openMulptyBrowser(browser, url);
		// loginPage
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToUserNameTxt(userName);
		loginPage.inputToPasswordTxt(password);
		// homePage
		homePage = loginPage.clickToLoginBtn();
		Assert.assertTrue(homePage.marquee());
	}

	@Test
	public void TC01_NameCannotBeEmpty() {
	}
	@Test
	public void TC02_NameCannotBeNumeric() {
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
