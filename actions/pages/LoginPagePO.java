package pages;

import org.openqa.selenium.WebDriver;
import commons.Constants;
import commons.AbstractPage;
import commons.PageFactoryManager;
import bankguru.LoginPageUI;
//Descip action in page

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
		sendKeyToElement(driver, LoginPageUI.USERNAME_TXT, Constants.USERNAME_TXT);
	}

	public void inputToPasswordTxt(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, Constants.PASSWORD_TXT);
	}

	public HomePagePO clickToLoginBtn() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
		return PageFactoryManager.getHomePage(driver);
	}

	public void clickToResetBtn() {
		waitForElementVisible(driver, LoginPageUI.RESET_BTN);
		clickToElement(driver, LoginPageUI.RESET_BTN);
	}

	public RegisterPagePO clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERELINK);
		clickToElement(driver, LoginPageUI.HERELINK);
		return PageFactoryManager.getRegisterPage(driver);
	}

}
