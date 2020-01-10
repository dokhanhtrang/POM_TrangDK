package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.NewCustomerPO;
import pages.RegisterPagePO;
import commons.Constants;

public class NewCustomer extends AbstractTest {
	WebDriver driver;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;
	private NewCustomerPO newCusPage;
	private EditCustomerPagePO editCusPage;
	String username, password, loginUrl, email, cusName, dob, add, city, state, pin, no, idCus;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openMulptyBrowser(browser, url);
		// login
		loginPage = PageFactoryManager.getLoginPage(driver);
		email = Constants.EMAIL_TXT;
		cusName = Constants.CUSNAME_TXT;
		dob = Constants.DOB_TXT;
		city = Constants.CITY_TXT;
		state = Constants.STATE_TXT;
		pin = Constants.PIN_TXT;
		no = Constants.NO_TXT;
		add = Constants.ADD_TXT;
	}

	@Test
	public void TC_Login01_CreateUser() {
		loginUrl = loginPage.getLoginPageUrl();
		// register
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDdTxt(email);
		System.out.println(email);
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
		verifyTrue(homePage.marquee());
		newCusPage = homePage.openNewCustomerPage(driver);
		newCusPage.inputEmptyCustomerName();
		newCusPage.clickOut();
		newCusPage.inputNumbericCustomerName();
		newCusPage.clickOut();
		newCusPage.inputScharCustomerName();
		newCusPage.clickOut();
		newCusPage.inputSpaceFCustomerName();
		newCusPage.clickOut();
//		newCusPage.inputToCustomerName(cusName);
//		newCusPage.checkFGender();
//		newCusPage.inputToDOB(dob);
//		newCusPage.inputToAdd(add);
//		newCusPage.inputToCity(city);
//		newCusPage.inputToState(state);
//		newCusPage.inputToPIN(pin);
//		newCusPage.inputToPhoneNo(no);
//		newCusPage.inputToEmail(email);
//		newCusPage.inputToPassword(password);
//		newCusPage.clickToSubmitBtn();
//		idCus = newCusPage.getCustomerIdInfor();
		
	}

	@AfterClass
	public void tearDown() {
		tearDown(driver);
	}

}
