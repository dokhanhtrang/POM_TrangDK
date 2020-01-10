package com.bankguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.RegisterPagePO;
import pages.LoginPagePO;
import pages.NewCustomerPO;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import commons.AbstractTest;
import commons.Constants;
import commons.PageFactoryManager;

public class Login_01_CreateUserAndLogin_PageObject extends AbstractTest {
	WebDriver driver;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;
	private NewCustomerPO newCusPage;
	private EditCustomerPagePO editCusPage;
	String username, password, loginUrl;
	String email = Constants.EMAIL_TXT;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMulptyBrowser(browser, url);
		// login
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void TC_Login01_CreateUser() {
		loginUrl = loginPage.getLoginPageUrl();
		// register
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDdTxt(email);
//		registerPage.getEmailInfo(email);
		System.out.println(email);
		registerPage.clickToSubmitBtn();
		username = registerPage.getUserIdInfor();
		password = registerPage.getPasswordInfor();
		System.out.println(password);
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
		verifyTrue(homePage.marquee());
		newCusPage = homePage.openNewCustomerPage(driver);
		System.out.println("open new");
		editCusPage = newCusPage.openEditCustomerPage(driver);
		System.out.println("open edit");
		homePage = editCusPage.openHomePage(driver);
		System.out.println("open home");
		loginPage = homePage.openLogoutPage(driver);
		System.out.println("login");
	}

	@AfterClass
	public void tearDown() {
		tearDown(driver);
	}

}
