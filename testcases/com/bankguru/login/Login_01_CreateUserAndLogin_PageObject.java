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
		//login
		loginPage = new LoginPagePO(driver);
		email = "khanhtrang" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_Login01_CreateUser() {
		loginUrl = loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();
		//register
		registerPage = new RegisterPagePO(driver);
		registerPage.inputToEmailIDdTxt(email);
		registerPage.clickToSubmitBtn();
		username = 	registerPage.getUserIdInfor();
		password = registerPage.getPasswordInfor();
	}

	@Test
	public void TC_Login02_LoginToApplication() {
		//login
		registerPage.openLoginPage(loginUrl); 
		loginPage = new LoginPagePO(driver);
		loginPage.inputToUserNameTxt(username);
		loginPage.inputToPasswordTxt(password);
		loginPage.clickToLoginBtn();
		//homepage
		homePage = new HomePagePO(driver);
		Assert.assertTrue(homePage.marquee());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
}
