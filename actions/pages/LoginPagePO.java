package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import bankguru.LoginPageUI;

public class LoginPagePO extends AbstractPage {
	WebDriver driver;
	
	public LoginPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}

	public void inputToUserNameTxt(String userName) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TXT);
		sendKeyToElement(driver, LoginPageUI.USERNAME_TXT, userName);
	}

	public void inputToPasswordTxt(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}

	public void clickToLoginBtn() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}

	public void clickToResetBtn() {
		waitForElementVisible(driver, LoginPageUI.RESET_BTN);
		clickToElement(driver, LoginPageUI.RESET_BTN);
	}

	public void clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERELINK);
		clickToElement(driver, LoginPageUI.HERELINK);
	}

}
