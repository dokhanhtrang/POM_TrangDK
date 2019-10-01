package com.bankguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.RegisterPagePO;
import pages.LoginPagePO;
import pages.HomePagePO;
import commons.AbstractTest;
import commons.PageFactoryManager;

public class Login_01_CreateUserAndLogin_PageObject extends AbstractTest {
	WebDriver driver;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;
	String username, password, loginUrl, email;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openMulptyBrowser(browser);
		// login
		loginPage = PageFactoryManager.getLoginPage(driver);
		email = "khanhtrang" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_Login01_CreateUser() {
		loginUrl = loginPage.getLoginPageUrl();
		// register
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDdTxt(email);
		registerPage.clickToSubmitBtn();
		username = registerPage.getUserIdInfor();
		password = registerPage.getPasswordInfor();
	}

	@Test
	public void TC_Login02_LoginToApplication() {
		// login
		loginPage = registerPage.openLoginPage(loginUrl);
		loginPage = new LoginPagePO(driver);
		loginPage.inputToUserNameTxt(username);
		loginPage.inputToPasswordTxt(password);
		// homepage
		homePage = loginPage.clickToLoginBtn();
		Assert.assertTrue(homePage.marquee());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
